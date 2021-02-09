<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script type="text/javascript">
        function checkValue()
        {
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }     
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }
    </script>
</head>
<body>
	Join Page
	<form method="post" action="MemberJoinAction" name="userInfo" onsubmit="return checkValue()">
           <table>
               <tr>
                   <td id="title">아이디</td>
                   <td>
                       <input type="text" name="id" maxlength="50">
                       <input type="button" value="중복확인" >    
                   </td>
               </tr>
                       
               <tr>
                   <td id="title">비밀번호</td>
                   <td>
                       <input type="password" name="password" maxlength="50">
                   </td>
               </tr>
               
               <tr>
                   <td id="title">비밀번호 확인</td>
                   <td>
                       <input type="password" name="passwordcheck" maxlength="50">
                   </td>
               </tr>
                   
               <tr>
                   <td id="title">이름</td>
                   <td>
                       <input type="text" name="name" maxlength="50">
                   </td>
               </tr>
                   
               <tr>
                   <td id="title">성별</td>
                   <td>
                       <input type="radio" name="gender" value="남" checked>남
                       <input type="radio" name="gender" value="여" checked>여
                   </td>
               </tr>
			<tr>
                   <td id="title">이메일</td>
                   <td>
                       <input type="text" name="mail" maxlength="50">
                   </td>
               </tr>
		 </table>
		 <br>
         <input type="submit" value="가입"/>  <input type="button" value="취소">
     </form>
</body>
</html>