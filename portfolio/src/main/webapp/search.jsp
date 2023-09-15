

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 폼 만들기</title>
</head>
<body>
<form id="f" method="post" action="./search.do">
검색어 입력 : <input type="text" name="search"><br>
<input type="button" value="검색" id=search>
</form>
</body>
<script>
document.querySelector("#search").addEventListener("click",function(){
	f.submit();
});
</script>
</html>