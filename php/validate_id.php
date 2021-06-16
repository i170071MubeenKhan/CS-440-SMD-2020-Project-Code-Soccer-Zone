<?php

include "conn.php";

$query = "SELECT name,email, id, password FROM user";
$result = mysqli_query($con, $query);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "email:" . $row["email"]. "- ID:" . $row["id"]. " - password:" . $row["password"];
  }
} else {
  echo "0 results";
}

?>