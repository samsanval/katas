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
    if($left > $right) {
        return -1;
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
$result = binaryChop(0,$array);
echo "El resultado es : $result \n";
$timeIterative = microtime(true) - $startTimeIterative;
echo "Execution time iterative $timeIterative\n";
$startTimeRecursive = microtime(true);
$resultRecursive = binaryChopRecursive(0,$array,0,sizeof($array)-1);
$timeRecursive = microtime(true) - $startTimeRecursive;

echo "El resultado recursivo es: $result \n";
echo "Execution time recursive $timeRecursive\n";
