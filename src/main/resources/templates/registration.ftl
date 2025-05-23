<#import "/spring.ftl" as s>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<h2> Registration </h2>

<form method="post" action="/registration">

    <@s.bind "users"/>

    <label for="username">User</label>
    <@s.formInput "users.username"/>
    <@s.showErrors "<br>"/><br>


    <label for="password">User</label>
    <@s.formInput "users.password"/>
    <@s.showErrors "<br>"/><br>

    <@s.bind "customer"/>
    <label for="firstName">firstName</label>
    <@s.formInput "customer.firstName"/>
    <@s.showErrors "<br>"/><br>

    <label for="lastName">lastName</label>
    <@s.formInput "customer.lastName"/>
    <@s.showErrors "<br>"/><br>

    <label for="email">email</label>
    <@s.formInput "customer.email"/>
    <@s.showErrors "<br>"/><br>

    <label for="phone">phone</label>
    <@s.formInput "customer.phone"/>
    <@s.showErrors "<br>"/><br>

    <button type="submit">Add</button>

</form>



</body>
</html>