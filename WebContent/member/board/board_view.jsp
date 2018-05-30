 <%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <title>뉴스 / 공지사항</title>
   <link rel="stylesheet" href="/StrutsBoard/board/common/css/css.css" type="text/css">
   
   <script type="text/javascript">
      function open_win_noresizable (url, name)
      {
         var oWin = window.open(url, name, "scrollbars=no,status=no,resizable=no, width=300, height=150");
         }
      
      </script>
      </head>
      
      <body>
         <table width="600" border="0" cellspacing="0" cellpadding="2">
            <tr>
               <td align="center"><h2>뉴스 / 공지사항</h2></td>
            </tr>
            <tr>
               <td height="20"></td>
            </tr>
         </table>
         
         <table width="600" border="0" cellspacing="0" cellpadding="0">
             <tr bgcolor="#777777">
               <td height="1" colspan="2"></td>
                </tr>
             <tr>
                    <td bgcolor="#F4F4F4"> 번호 </td>
                    <td bgcolor="#FFFFFF">
                      &nbsp;&nbsp;<s:property value="resultClass.board_num" />
                    </td>
                   </tr>
               <tr bgcolor="#777777">
                    <td height="1" colspan="2"></td>   
                </tr>
      
      <tr>
        <td width="100" bgcolor="#F4F4F4">  제목</td>
        <td width="500" bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.board_subject" />
        </td>
      </tr>
                           
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  글쓴이 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.board_admin" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>   
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  내용 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.board_content" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  조회수 </td>
        <td bgcolor="#FFFFFF">
          <s:property value="resultClass.board_readhit" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>   
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  등록날짜 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp;<s:property value="resultClass.board_regdate" />
        </td>
      </tr>
      <tr bgcolor="#777777">
        <td height="1" colspan="2"></td>   
      </tr>
      
      <tr>
        <td bgcolor="#F4F4F4">  첨부파일 </td>
        <td bgcolor="#FFFFFF">
          &nbsp;&nbsp; <s:property value="resultClass.board_orgname" />
         
         </td> 
         </tr>
      <tr bgcolor="#777777">
         <td colspan="2" height="1"></td>
      </tr>
      <tr>
         <td colspan="2" height="10"></td>
      </tr>
      
     <!-- 댓글달기 -->
         <tr>
         <td colspan="2" height="10">
            <form action="CommentAction.action" method="post">
               <table>
                  <tr>
                     <td width="170">
                        이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름 <s:textfield name="comment_name" theme="simple" value="" cssStyle="width:100px" maxlength="20" /><br>
                        비밀번호 <s:textfield name="comment_password" theme="simple" value="" cssStyle="width:100px" maxlength="20" />
                     </td>
                     <s:hidden name="originno" value="%{resultClass.originno}" />
               <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                     <s:hidden name="comment_number" value="%{resultClass.comment_number}" />
                     <s:hidden name="currentPage" value="%{currentPage}" />
               <!-- !!!!!!!!!!!!!!!!!!!!!!!!수정!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                     <td align="left">
                        <s:textarea name="comment_content" theme="simple" value="" cols="60" rows="3" />
                     </td>
                  </tr>
                  <tr>
                     <td colspan="2" align="right">
                        <input name="submit" type="submit" value="작성완료" class="inputb">
                     </td>
                  </tr>
               </table>
            </form>
         </td>
      </tr>
   
      <tr bgcolor="#777777">
         <td colspan="2" height="1"></td>
      </tr>
   
   
      <s:iterator value="commentlist" status="stat">
      <tr>
         <td height="10" width="130" align="center">
            <s:property value="comment_name" /><br>
            <s:property value="comment_date" /><br><br>
         </td>
         <td>
         <s:property value="comment_content" /> 
            <a href="javascript:open_win_noresizable('checkForm2.action?no=<s:property value="comment_num" />&originno=<s:property value="originno" />&currentPage=<s:property value="currentPage" />','cdelete')">x</a>
         </td>
      </tr>
      <tr bgcolor="#777777">
         <td colspan="2" height="1"></td>
      </tr>
      </s:iterator>
      <tr>
         <td colspan="2" height="10">
            <s:if test="commentlist.size() <= 0">
            댓글없음
         </td>
      </tr>
            </s:if>   
   
      <tr bgcolor="#777777">
         <td colspan="2" height="1"></td>
      </tr>
      <tr>
         <td colspan="2" height="10"></td>
      </tr> 
   <!-- 댓글달기 -->
      
 

        <tr>
         <td colspan="2" align="right">
   <input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='AdminBoardListAction.action?currentPage=<s:property value="currentPage" />'">

        </td>
      </tr>

  </table>
 </body>
</html></html>