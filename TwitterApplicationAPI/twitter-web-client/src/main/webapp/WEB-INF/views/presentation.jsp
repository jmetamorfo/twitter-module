<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Spring MVC Auto Complete with JQuery</title>
        <link rel="stylesheet" type="text/css"
              href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
              integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" 
              crossorigin="anonymous">


        <script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
        crossorigin="anonymous"></script>

    </head>
    <body>

        <div class="row">
            <div class="col-sm-6">
                 <h1>Spring MVC with JQuery</h1>
                <form class="form-horizontal" id="target">
                    <fieldset>
                        <!-- change col-sm-N to reflect how you would like your column spacing (http://getbootstrap.com/css/#forms-control-sizes) -->
                        <!-- Form Name -->
                        <legend>Twitter Direct Messages</legend>

                        <!-- Text input http://getbootstrap.com/css/#forms -->
                        <div class="form-group">
                            <label for="textinput" class="control-label col-sm-2">Screen Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="screenName" placeholder="Type the screen name.">
                                <p class="help-block">help</p>
                            </div>
                        </div>
                        <!-- Textarea http://getbootstrap.com/css/#textarea -->
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="message">Message:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="message" name="message" rows="3"></textarea>
                                <p class="help-block">help</p>
                            </div>
                        </div>

                        <!-- Button http://getbootstrap.com/css/#buttons -->
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="send">Single Button</label>
                            <div class="text-center col-sm-10">
                                <button type="submit" id="send" name="send" class="btn btn-primary" aria-label="Single Button">Send message</button>
                                <p class="help-block">help</p>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>



        <!--h1>Spring MVC with JQuery</h1>

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
        </form-->


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