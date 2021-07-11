<?php

function binaryChop(int $number, $array): int
{
    $left = 0;
    $right = sizeof($array) - 1;
    echo "El array es de $right \n";
    $middle = round(($right+$left) / 2);
    $found = -2;
    do {
        echo "Left : $left Right: $right Middle: $middle \n";
        if($array[$middle] <  $number){
            $left = $middle +1;
            $middle = round(($right+$left) / 2);

        }
        else if ($array[$middle] > $number) {
            $right = $middle - 1;
            $middle = round(($right+$left) / 2);
        }
        else if($array[$middle] == $number || $left == $right){
            $found = $middle;
        }
        if($left > $right  && $found == 0) {
            $found = -1;
        }
    } while($found == -2);
    return $found;

}
$array = [1,2,3,5,7.11,16,20];
sort($array);
$result = binaryChop(2,$array);
echo $result . "\n";
