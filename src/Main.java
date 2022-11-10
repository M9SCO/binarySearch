import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    //
    static int comparisonCount = 2;
    static StringBuilder code = new StringBuilder();
    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> array = new ArrayList<>();
    //
    static int res;
    static int item;


    public static void main(String[] args) {
        System.out.println("Программа запущенна");

// Заполнение переменных программы
        array = fill_array();

        System.out.println("Введите элемент для бинарного поиска: ");
        System.out.print(">:");
        item = input.nextInt();

// Cортировка и отображение заполненного массива
        Collections.sort(array);
        System.out.println("Отсортированный массив: ");
        array.forEach(s -> System.out.print(s + " "));
        System.out.println();

// Поиск элемента
        try {
            res = binaryFind(array, item);
            System.out.printf("Элемент %s найден на позиции %s после %s сравнений%n", item, res, item);
        } catch (ArrayIndexOutOfBoundsException e) { // В случае ненахождении вызывается данная ошибка
            System.out.println("Элемент не найден");
        }
        System.out.println(code);

    }

    public static ArrayList<Integer> fill_array() {
        System.out.println("Вводите числа, разделяя их нажатием Enter, двойным нажатием Enter завершите ввод.");
        ArrayList<Integer> integers = new ArrayList<>();
        while (true) {
            System.out.print(">:");
            String el = input.nextLine();
            if (el.isEmpty()) break;
            try {
                integers.add(Integer.parseInt(el));

            } catch (NumberFormatException ignored) {

            }

        }
        return integers;
    }


    public static int binaryFind(ArrayList<Integer> array, int key) throws ArrayIndexOutOfBoundsException {
        int firstIndex = 0;
        int lastIndex = array.size() - 1;//код 1 меньше 0 больше


        while (firstIndex <= lastIndex) { // пока элементы не сойдутся
            comparisonCount++;
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array.get(middleIndex) == key) {
                return middleIndex + 1;
            } else if (array.get(middleIndex) < key) {
                firstIndex = middleIndex + 1;
                code.append("1");
            } else if (array.get(middleIndex) > key) {
                lastIndex = middleIndex - 1;
                code.append("0");
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}

/*
1367
3037
59
83
1259
317
3469
2083
3461
3391
1543
2707
229
89
1049
1291
2593
2069
617
379
859
739
389
3187
2647
1613
3467
857
2399
643
431
311
2341
263
823
2969
1607
3527
3463
2549
3163
13
3271
2939
1489
277
607
1931
347
1439
2179
2017
3137
1093
1487
61
2903
1303
1907
1013
1361
79
2741
1523
503
1567
2377
313
883
587
2099
2137
3371
1327
2221
1427
2081
2579
2957
1549
821
2797
2351
2381
2053
1319
601
191
3407
457
761
131
3571
2729
1091
3257
3343
3181
1601
2
3221
2423
2503
17
3079
2927
2767
283
499
173
569
599
683
2719
163
257
2953
1609
2339
1213
2731
2633
1217
19
2039
157
983
997
73
1009
1759
479
2213
109
1171
1063
1039
103
743
1051
2237
1117
1699
653
2417
331
1693
3217
2851
787
1979
2287
811
1811
1579
2243
2357
2803
521
2089
1151
2011
2029
751
3307
97
887
593
541
1409
1597
2749
2857
1741
3121
1889
3541
2087
1861
2297
307
1721
631
2269
2447
1933
409
709
2129
947
467
1423
2819
911
2113
773
3299
2843
1453
3023
1949
1429
3329
2473
3433
461
1019
2267
1663
691
3539
647
953
1481
3067
1201
3361
3347
809
1913
1619
2003
2693
3533
29
659
2251
113
1831
3319
359
1621
1307
2311
2437
1627
233
2917
1279
443
727
1297
1733
449
509
907
919
853
293
827
2063
2777
269
1847
1483
2239
2477
881
3011
421
271
1447
2677
1061
1289
2441
2027
2591
149
373
2411
3557
3229
2837
2131
1181
1709
523
251
1571
3559
37
2617
1993
7
547
1231
23
641
2203
1373
1871
839
3253
3209
797
1223
661
1747
127
1381
1069
1753
1103
3331
1493
181
2687
439
3089
419
223
241
2383
941
971
2371
1553
977
2539
3167
937
2459
563
3049
3061
1433
43
2711
3389
2543
211
151
3191
3373
227
1723
2153
2293
139
2791
3529
3449
41
71
829
2897
677
1559
491
2273
1153
619
3
1033
5
1249
2963
1123
3109
1879
2801
2467
3517
397
2557
2789
1021
1129
571
1783
2699
487
3203
2621
991
1301
1109
3041
2551
2531
719
433
967
367
179
2833
1637
3323
2861
863
3169
613
2281
1163
1031
1823
701
2333
2887
1873
2689
1511
401
769
2347
199
1097
101
193
167
2111
463
337
1277
1789
1399
1973
2609
281
1867
3119
2389
2999
197
1499
2659
3499
1657
1187
3001
2393
3083
47
3019
1087
1777
2663
383
1531
3457
2309
107
1987
2141
2671
2879
929
1283
3359
1787
67
353
2161
3491
1229
733
3511
3313
2753
11
349
1667
577
557
1471
673
1999
1697
53
3259
3301
1877
2207
2683
2713
3547
1997
877
1321
1901
1801
2971
757
1951
1583
2909
3251
1669
239
137
1451
2521
1193
1237
2657
2143
31
1459
3413

 */