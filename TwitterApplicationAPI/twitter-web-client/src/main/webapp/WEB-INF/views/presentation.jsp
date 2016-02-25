<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Spring MVC Auto Complete with JQuery</title>
        <link rel="stylesheet" type="text/css"
              href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

        <script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

    </head>
    <body>

        <h2>Spring MVC Autocomplete with JQuery</h2>


        <div id="test">
            <span>This is my test</span>
        </div>


        <ul>
            <li>
                <label>Member ID</label>
                <input id="member_id" type="text" />
                <input id="blnLoadMember" type="button" value="Get Details" />
            </li>
        </ul>


        <script type="text/javascript">


            $(document).ready(function () {


                $("#test").after("TEST 3");

                $('input[type=button]').attr('disabled', true);
                $("#MemberDetails").html('');
                $("#MemberDetails").addClass("loading");
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/twitter-rest-api/webresources/twitter/message",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: OnGetMemberSuccess,
                    error: OnGetMemberError
                });


                function OnGetMemberSuccess(data, status) {
                    //jQuery code will go here...
                    alert("awiwi");
                    console.log(data);
                    
                    for (var x = 0; x < data.length; x++) {
                        console.log(data[x].client);
                        $("#test").after(data[x].client)
                        
                    }
                }

                function OnGetMemberError(request, status, error) {
                    //jQuery code will go here...
                    alert("Dammit");
                }




            });
        </script>

    </body>
</html>