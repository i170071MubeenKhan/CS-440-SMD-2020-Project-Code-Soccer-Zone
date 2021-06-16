<?php

include "conn.php";

$query = "SELECT email, id, password FROM user";
$result = mysqli_query($con, $query);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "email:" . $row["email"]. " - password:" . $row["password"]. "|- ID:" . $row["id"]. "___" ;
  }
} else {
  echo "0 results";
}

?>