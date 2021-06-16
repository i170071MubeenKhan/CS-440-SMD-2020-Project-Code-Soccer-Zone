<?php

include "conn.php";

$query = "SELECT * FROM items";
$result = mysqli_query($con, $query);


if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "id:" . $row["id"]. " - name:" . $row["name"]. " - brand:" . $row["brand"]. " - type:" . $row["type"]. " - items_remaining:" . $row["items_remaining"].  " - description:" . $row["description"].  " - original_price:" . $row["original_price"]. " - discounted_price:" . $row["discounted_price"]. " - release_date:" . $row["release_date"]. " ---" . "\r\n";
  }
} else {
  echo "0 results";
}

?>