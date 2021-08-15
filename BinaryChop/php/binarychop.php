<?php

function binaryChop(int $number, array $array): int
{
    $left = 0;
    $right = sizeof($array) - 1;
    $middle = round(($right+$left) / 2);
    $found = -2;
    do {
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

function binaryChopRecursive(int $number, array $array, int $left, int $right): int
{
    $middle = round(($right+$left) / 2);
    if($array[$middle] === $number){
        return $middle;
    }
    if($left === $right) {
        return 0;
    }
    if($array[$middle] < $number) {
        $left = $middle + 1;
    }
    if($array[$middle] > $number){
        $right = $middle - 1;
    }
    return binaryChopRecursive($number,$array,$left,$right);



}
$array = [];
for ($i = 0; $i < 10000; $i++) {
    $array[] = $i;
}
$startTimeIterative = microtime(true);
$result = binaryChop(6,$array);
echo "El resultado es : $result \n";
$timeIterative = microtime(true) - $startTimeIterative;
echo "Execution time iterative $timeIterative\n";

$resultRecursive = binaryChopRecursive(6,$array,0,sizeof($array)-1);
echo "El resultado recursivo es: $result \n";