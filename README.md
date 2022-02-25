4. Napisz program, który pobierze od użytkownika macierz sąsiedztwa grafu G (wierzchołki numerujemy od jedynki), a następnie
wyświetli następujące informacje (każda informacja w osobnej linii):

    Ilość wierzchołków
    Ilość krawędzi
    Ciąg stopni (nieposortowane)
    Średni stopień grafu
    Informacja czy graf jest pełny/cykl/ścieżka/drzewo/lub nie należy do żadnych

Sprawdzamy w podanej powyżej kolejności i wypisujemy każdy poprawny wynik. Zakładamy dla prostoty, że grafy są spójne, ale dopuszczamy wierzchołki izolowane.

5. Algorytm przeszukiwanie grafu w głąb (DFS):

    Odwiedzamy wierzchołek vvv (zaznaczamy go jako odwiedzony) i wkładamy go na STOS
    Dopóki STOS nie jest pusty wykonuj:
         Jeżeli vvv jest wierzchołkiem na wierzchu STOSU, to sprawdzamy czy istnieje wierzchołek sąsiedni z vvv (zgodnie z porządkiem bierzemy najmniejszy z sąsiadów), który nie był jeszcze odwiedzony.
        Jeżeli uu jest takim wierzchołkiem, to odwiedzamy uuu i wkładamy go na stos.
        Jeżeli takiego uu nie ma, to zdejmujemy vvv ze stosu.

Napisz program, który wczytuje od użytkownika macierz sąsiedztwa, następnie numer wierzchołka, i przeprowadza przeszukiwanie w głąb tego grafu według powyższej modyfikacji algorytmu. Wynikiem ma być kolejność odwiedzanych wierzchołków w tym grafie oraz informacja czy graf jest spójny czy nie.

W przypadku błędnych danych program ma wypisać komunikat: BŁĄD i ma zakończyć działanie.

5(2). Napisz program, który wczytuje od użytkownika macierz sąsiedztwa, a następnie wypisuje wagę najmniejszego drzewa spinającego tego grafu. W przypadku niespójnego grafu, program powinien wypisać komunikat: Graf nie jest spójny.

(+ 2 pkt) - Skorzystanie z tzw. zbiorów rozłącznych.

6. Średnicą grafu diam(G)\text {diam(G)}diam(G) grafu G=(VG,EG)G = (V_G,E_G)G=(VG​,EG​) nazywamy największą odległość najkrótszych ścieżek, jaka występuje między wierzchołkami.

Napisz program, który dla danej ważonej macierzy sąsiedztwa wagami obliczy jego średnicę.

Dla prostoty zakładamy, że grafy są spójne i jego wagi są dodatnie.

7. Napisz program, który pobiera graf nieskierowany podany jako lista sąsiedztwa. Następnie wczytuje wiersz, który reprezentuje kolory poszczególnych wierzchołków tego grafu. Wynikiem programu ma być informacja, czy dane kolorowanie wierzchołków (w klasycznym sensie) jest legalne czy nie.

7(2). Napisz program, który dla grafu podanego jako lista sąsiedztwa, wypisze kolorowanie wierzchołków przeprowadzone za pomocą algorytmu LF (largest first). Ponadto program ma wypisać liczbę chromatyczną otrzymaną w wyniku tego pokolorowania.

Zakładamy, że wybieramy niepokolorowany wierzchołek o najwyższym stopniu i najwyższym labelu. Oznacza to, że jeśli wierzchołek 2 ma stopień 4 oraz wierzchołek 3 ma stopień 4 to wybieramy najpierw wierzchołek 3.

Natomiast podczas przeszukiwania sąsiadów zaczynamy zawsze od sąsiada z najmniejszym labelem.

8. Napisz program, który dla podanego grafu dwudzielnego G=((A,B);EG)G = ((A,B);E_G)G=((A,B);EG​) w postaci listy sąsiedztwa stwierdzi, czy istnieje skojarzenie całkowite ze zbioru AAA w zbiór BBB.

(+ 2 pkt) Za wyświetlenie skojarzenia całkowitego w danym grafie.

8(2). Napisz program, który dla grafu podanego jako lista sąsiedztwa, wypisze jego kwadrat. 

Bierzemy tu pod uwagę grafy nieskierowane jak i skierowane.
