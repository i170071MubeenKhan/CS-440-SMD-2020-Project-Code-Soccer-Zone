<?php

include "conn.php";
$responce = array();

if (isset($_POST["name"], $_POST["brand"], $_POST["type"], $_POST["items_remaining"],$_POST["description"],$_POST["original_price"],$_POST["discounted_price"],$_POST["release_date"]))
{
	$name = $_POST["name"];
	$brand = $_POST["brand"];
	$type = $_POST["type"];
	$items_remaining = $_POST["items_remaining"];
	$description = $_POST["description"];
	$original_price = $_POST["original_price"];
	$discounted_price = $_POST["discounted_price"];
	$release_date = $_POST["release_date"];



	$query = "INSERT INTO `items`(`name`, `brand`, `type`, `items_remaining`, `description`,`original_price`,`discounted_price`,`release_date`) VALUES
	 ('$name', '$brand', '$type', '$items_remaining', '$description', '$original_price', '$discounted_price', '$release_date')"; 

	$res = mysqli_query($con, $query);

	#positive result
	if($res) {
		$responce['id'] = mysqli_insert_id($con);
    	$responce['reqmsg'] = "Item inserted!";
    	$responce['reqcode'] = "1";
	}
	else { #negative result
		$responce['id'] = "NA";
    	$responce['reqmsg'] = "Error inserting item!";
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