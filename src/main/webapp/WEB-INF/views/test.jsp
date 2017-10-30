<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<body>
 <span>"当前登录IP是" ${ip}</span>

 <form id="upload-form" action="/SpringMvcDemo/user/userUpload" method="post" enctype="multipart/form-data" >
  　　　<input type="file" id="upload" name="file"/>
        <input type="text" name="fname" value="fname"/></p>
  　　　 <input type="submit" value="Upload" />
 </form>
</body>
</html>

