package com.example.areyouhot.view

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.areyouhot.model.User
import com.example.areyouhot.model.sampleMatches
import com.example.areyouhot.model.sampleUser
import com.example.areyouhot.model.sampleUserList
import com.example.areyouhot.view.theme.BackButton
import com.example.areyouhot.view.theme.Divider
import com.example.areyouhot.view.theme.Typography

@Composable
fun SearchActivity(
    navController: NavController
) {
    val searchQuery = remember { mutableStateOf("") }
    val tabLayoutState = remember { mutableIntStateOf(0) }
    val filteredMatches = remember(searchQuery.value, sampleMatches) {
        sampleMatches.filter { match ->
            match.toString().contains(searchQuery.value, ignoreCase = true)
        }
    }

    val filteredEnemies = remember(searchQuery.value, sampleUserList) {
        sampleUserList.filter { user ->
            user.nickname.contains(searchQuery.value, ignoreCase = true)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7f)
                .padding(16.dp)) {
                BackButton { }
                SearchBar(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    onSearch = { query ->
                        searchQuery.value = query
                        when (tabLayoutState.intValue) {
                            0 -> Log.d("SEARCH", "Matches filtered: ${filteredMatches.size}")
                            1 -> Log.d("SEARCH", "Enemies filtered: ${filteredEnemies.size}")
                        }
                    }
                )
            }
            TabRow(
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = tabLayoutState.intValue,
                containerColor = Color.White,
                contentColor = Black,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[tabLayoutState.intValue]),
                        color = Black
                    )
                }
            ) {
                // 탭 아이템들
                Tab(
                    selected = tabLayoutState.intValue == 0,
                    onClick = { tabLayoutState.intValue = 0 },
                    selectedContentColor = Black,
                    unselectedContentColor = Gray,
                    text = { Text("대결") }
                )
                Tab(
                    selected = tabLayoutState.intValue == 1,
                    onClick = { tabLayoutState.intValue = 1 },
                    selectedContentColor = Black,
                    unselectedContentColor = Gray,
                    text = { Text("적수") }
                )
            }

            when (tabLayoutState.intValue) {
                0 -> MatchList(filteredMatches, navController = navController)
                1 -> EnemyList(enemyList = filteredEnemies)
            }
        }
    }
}

@Composable
fun EmptyScreen(tabIndex: Int) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("$tabIndex")
    }
}

@Composable
fun EnemyList(enemyList: List<User>) {
    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                count = enemyList.size,
                key = { index -> enemyList[index].nickname },
                contentType = { index -> enemyList[index] }
            ) { index ->
                EnemyItem(enemyList[index])
                Divider(1f)
            }
        }
    }
}

@Composable
private fun EnemyItem(enemy: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4f)
            .clickable {}
            .padding(10.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = enemy.profileImage),
                contentDescription = enemy.nickname + "Profile",
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(enemy.nickname, style = Typography.bodyLarge)
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(enemy.tier.tierName, modifier = Modifier.fillMaxWidth(), style = Typography.bodyMedium)
        }
    }
}

@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "검색어를 입력하세요",
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F1F2), RoundedCornerShape(8.dp))
            .padding(12.dp)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        textStyle = typography.bodySmall,
        enabled = enabled,
        singleLine = true,
        interactionSource = interactionSource,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(value)
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(7f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 왼쪽 검색 아이콘
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "검색",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )

                // 텍스트 필드 영역
                Box(
                    Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value == "" && !isFocused.value) {
                        Text(
                            text = hint,
                            color = Color.Gray,
                            style = LocalTextStyle.current.copy(
                                fontSize = 14.sp
                            )
                        )
                    }
                    innerTextField()
                }

                AnimatedVisibility(
                    visible = value.isNotEmpty(),
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    IconButton(
                        onClick = { onValueChange("") },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "텍스트 지우기",
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchActivityPreview() {
    EnemyItem(sampleUser)
}