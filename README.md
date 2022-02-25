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

7.
