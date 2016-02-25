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

        <h1>Spring MVC with JQuery</h1>
        
        <h2>TWITTER DIRECT MESSAGES</h2>
        
        <h3>Send a Direct Message</h3>


        <div id="test">
            <span>This is my test</span>
        </div>


        <form id="target" action="destination.html">
            <input type="text" id="screenName" placeholder="Add screen name">
            <br>
            <textarea id="message"></textarea>
            <br>
            <input type="submit" value="SEND TWEET">
        </form>


        <script type="text/javascript">


            $(document).ready(function () {

                /*$('input[type=button]').attr('disabled', true);
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
                    console.log(data);

                    for (var x = 0; x < data.length; x++) {
                        console.log(data[x].client);
                        $("#test").after(data[x].client)

                    }
                }

                function OnGetMemberError(request, status, error) {
                    //jQuery code will go here...
                }
                */


                $("#target").submit(function (event) {
                    alert("Handler for .submit() called.");
                    event.preventDefault();
                    
                    var screenName = $("#screenName").val();
                    var message = $("#message").val();
                    
                    alert(screenName);
                    alert(message);
                    var weServiceUrl = "http://localhost:8080/twitter-rest-api/webresources/twitter/post/directmessage"
                    $.ajax({
                        type: "POST",
                        url: weServiceUrl,
                        data: {
                            screenName : screenName,
                            text : message
                        },
                        dataType: "json",
                        success: OnGetMemberSuccess,
                        error: OnGetMemberError
                    });

                });

                $("#other").click(function () {
                    $("#target").submit();
                });
                
                
                function OnGetMemberSuccess(data, status) {
                    //jQuery code will go here...
                    alert("yeaqqaaaaa");
                    
                }

                function OnGetMemberError(request, status, error) {
                    //jQuery code will go here...
                    alert("xxxx");
                }


            });
        </script>

    </body>
</html>