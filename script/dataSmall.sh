#!/bin/bash
 for i in {5..25..2}
do
    mkdir -p $i/data;
    mkdir -p $i/result;
     for j in {1..20..1}
     do
        ./a.out $i 30 100 >> "./$i/data/$i_$j"
    done

done
