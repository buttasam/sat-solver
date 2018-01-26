#!/bin/bash
 for i in {100..500..100}
do
    mkdir -p $i/data;
    mkdir -p $i/result;
     for j in {1..5..1}
     do
        ./a.out $i 500 100 >> "./$i/data/$i_$j"
    done

done
