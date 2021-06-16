<?php

include "conn.php";
$responce = array();

if (isset($_POST["name"],$_POST["email"], $_POST["password"]))
{
	$name=$_POST["name"];
	$email = $_POST["email"];
	$password = $_POST["password"];


	$query = "INSERT INTO `user`(`name`,`email`, `password`) VALUES ('$name','$email', '$password')"; 

	$res = mysqli_query($con, $query);

	#positive result
	if($res) {
		$responce['id'] = mysqli_insert_id($con);
    	$responce['reqmsg'] = "User inserted!";
    	$responce['reqcode'] = "1";
	}
	else { #negative result
		$responce['id'] = "NA";
		$responce['name'] = $name;
		$responce['name1'] = "$name";
		$responce['email'] = $email;
		$responce['password'] = $password;
    	$responce['reqmsg'] = "Error inserting User!";
    	$responce['reqcode'] = "0";
	}
} 
else 
{
    $responce['id'] = "NA";
    $responce['reqmsg'] = "Incomplete request!";
    $responce['reqcode'] = "0";
}

$x = json_encode($responce);
echo $x;

?>