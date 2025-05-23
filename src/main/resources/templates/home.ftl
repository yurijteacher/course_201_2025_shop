<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>${message}</h1>

<h2> List Categories </h2>


<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>
    <#if categories??>
        <#list categories as category>
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td>${category.image}</td>
            </tr>
        </#list>
    </#if>

    </tbody>
</table>

<hr>

<h2> Update/Delete</h2>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>image</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>
    <#if categories??>
        <#list categories as category>
            <tr>
                <form action="/updateCategory" method="post">
                    <input type="hidden" name="id" value="${category.id}">
                    <td>${category.id}</td>
                    <td><input type="text" name="name" value="${category.name}"></td>
                    <td><input type="text" name="description" value="${category.description}"></td>
                    <td><input type="text" name="image" value="${category.image}"></td>
                    <td>
                        <button type="submit">update</button>
                    </td>
                </form>
                <form action="/deleteCategory" method="post">
                    <input type="hidden" name="id" value="${category.id}">
                    <td>
                        <button type="submit">delete</button>
                    </td>
                </form>
            </tr>
        </#list>
    </#if>

    </tbody>
</table>


<div class="container">

    <div class="row">
        <div class="col-8">
            <a href="http://localhost:8080/delivery">Delivery</a>
        </div>
        <div class="col-8">
            <a href="http://localhost:8080/payment">Payment</a></div>
        <div class="col-8"></div>
    </div>
</div>

<hr>
<h2> Save New Category </h2>
<form action="/saveNewCategory" method="post">

    <label for="name">Name</label><br>
    <input type="text" name="name" placeholder="name" id="name"><br>

    <label for="description">description</label><br>
    <input type="text" name="description" placeholder="description" id="description"><br>

    <label for="image">Name</label><br>
    <input type="text" name="image" placeholder="image" id="image"><br>

    <button type="submit">Add</button>

</form>

</body>
</html>