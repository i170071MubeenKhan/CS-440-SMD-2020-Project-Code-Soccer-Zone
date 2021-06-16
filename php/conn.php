<?php
$con = mysqli_connect("localhost", "root", "") or die("Unable to connect to database!".mysql_errno());

mysqli_select_db($con, "smd_project");
mysqli_query($con, "SET NAMES 'utf8'");

?>