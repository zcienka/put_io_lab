# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. 
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Odnotowuje wysyłanie produktu do kupującego w systemie

[Kupujący](#ac2)
* [UC3](#uc3): Finalizuje płatność w systemie
* [UC4](#uc4): Informuje system o wzięciu udziału w aukcji

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Odnotowanie wysyłania produktu do kupującego w systemie

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2), 

**Scenariusz główny:**
1. System czeka na zatwierdzenie wysłania produktu do sprzedawcy
2. Kupujący zatwierdza wysłanie produktu do sprzedawcy
3. System wysyła informacje o miejscu odbioru paczki przez kuriera
4. System odbiera informację o odbiorze paczki przez kuriera
5. Kupujący zatwierdza opcję odebrania paczki w systemie
6. System odbiera informację o odebraniu paczki przez kupującego

**Scenariusze alternatywne:** 

2.A. Podano niepoprawny adres odbioru
* 2.A.1. System informuje o błędnie podanym adresie odbioru
* 2.A.2. Sprzedającemu zostaje przyznana kara finansowa

6.A Kupujący nie odbiera towaru
* 6.A.1 System zostaje poinformowany o zwrocie paczki
* 6.A.2 System informuje o braku odebrania towaru przez kupującego
* 6.A.3 Kupującemu zostaje przyznana kara finansowa

---


<a id="uc3"></a>
### UC3: Finalizacja płatności w systemie

**Aktorzy:** [Kupujący](#ac2), 

**Scenariusz główny:**

1. System informuje o metodzie platności
2. Kupujący wybiera metodę płasności
3. System informuje o konieczności wprowadzenia danych
4. Kupujący wprowadza dane
5. System weryfikuje poprawność wprowadzenia danych
6. System przekazuje wprowadzone dane bankowi

**Scenariusze alternatywne:** 

5.A System otrzymuje informację, że wprowadzone dane są niepoprawne
* 5.A.1. System informuje o błędnie podanych danych płatności
* 5.A.2. System nakłada karę na kupującego
* 5.A.3. Transakcja nie dochodzi do skutku

--- 

<a id="uc4"></a>
### UC4: Poinformowanie systemu o wzięciu udziału w aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**

1. Kupujący zgłasza do systemu chęć wzięcia udziału w aukcji
2. System informuje kupującego o konieczności podania danych osobowych
3. Kupujący wypełnia dane osobowe
4. System weryfikuje dane
5. System informuje o konieczności podania kwoty wywoławczej
6. System weryfikuje dane dotyczące kwoty
7. System informuje o pomyślnym wzięciu udziału w transakcji

**Scenariusze alternatywne:** 

4.A Podano niepoprawne dane
* 4.A.1. System informuje o niepoprawnym podaniu danych
* 4.A.2. System informuje uzytkownika o ponownym podaniu danych

6.A Podano niepoprawną kwotę wywoławczą
* 6.A.1. System informuje o podaniu niepoprawnej kwoty wywoławczej
* 6.A.2. System informuje uzytkownika o ponownym podaniu danych



---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| UC2: Odnotowanie wysyłania produktu do kupującego w systemie                                              |  C   |  ... | ... | ...|
| UC3: Finalizacja płatności w systemie| U| ... |
| UC4: Informowanie systemu o wzięciu udziału w aukcji| U | ...|


