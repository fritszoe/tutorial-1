# Fatih Raditya Pratama - 2206083520
<details> 
<summary>Reflection-1 (MODULE-01)</summary>

Menurut saya selama tutorial ini, sudah memenuhi standar clean code, akan tetapi untuk secure coding sendiri saya masih kurang paham, namun sepertinya sudah aman, 
karena saat membuat product itu yang diminta jelas, String dan int, mungkin masih ada celah tapi saya masih belum terlalu paham terkait cara melakukan secure coding itu sendiri.

Mungkin kekurangan dari code ini adalah, code ini belum melakukan prevensi jika quantity dari Product nya < 0. Sehingga Product yang ada bisa minus.
</details>
<details>
<summary>Reflection-2 (MODULE-01)</summary>

## 1. 
Membuat unit test sangat membantu dalam memahami program lebih jauh lagi, menurut saya sendiri membuat unit test itu lumayan menyenangkan, untuk berapa banyak unit test
yang diperlukan, kita perlu membuat unit test untuk setiap fitur yang kita buat dalam program kita serta kemungkinan-kemungkinan yang berkaitan dengan fitur yang kita
buat tadi. Contohnya dalam hal ini adalah test untuk melihat apakah Product yang sudah di delete masih ada dalam productRepository atau tidak.
## 2. Saya masih kurang mengerti bagian functional test ini.
</details>

<details>
<summary>Reflection-3 (MODULE-02)</summary>

## 1.
Tadi code quality Issue yang saya alami hanya masalah dead code saja. Untungnya tidak ada yang aneh-aneh. Strategi saya dalam menghadapi code quality issue tinggal melakukan deletion
terhadap code-code yang tidak saya pakai. Selain itu, ada juga import-import yang tidak terpakai dan saya delete.

## 2.
Ya, code saya sudah ada automated build script yang akan melakukan continous change thd codebase nya. Tes-tes nya juga sudah cukup memadai, sehingga harusnya mencukupi. Selain itu, deployment
nya juga sudah automatic dengan menggunakan github actions.
</details>

<details>
<summary>Reflection-4 (MODULE-03)</summary>
1.) SRP, Pemisahan antara CarController dan ProductController sehingga keudanya punya purpose masing-masing. Selain itu, UUID pada bagian create di CarRepository tidak diperlukan, bisa kita pindahkan saja ke constructor di model Car.Java, sehingga CarRepository.create benar-benar hanya menambahkan object Car ke dalam List. 

Selain itu, mungkin pada bagian return seperti di bagian create dan update, tidak perlu return object Car, karena sebenarnya return nya tadi juga tidak digunakan karena object nya sudah berada di dalam list.

2.) OCP, Menurut saya sudah benar karena kita bisa menambahkan class lain dari car atau product, kita tidak perlu memodifikasi dan tinggal sambung-sambungin saja, attribute nya sesuai dengan car dan repository nya tinggal menggunakan CarRepository untuk mengurusnya.

3.) LSP tidak dibutuhkan di sini, misalnya Deque dan ArrayDeque, ArrayDeque tetap interchangeable sama Deque, dia ttp bisa pakai dr Deque(Semua yg dr Deque). Dan di sini blm ada inheritance yang dibutuhkan, mungkin hanya di bagian interface saja.

4.) ISP, Menurut saya ISP di sini sudah benar, karena masing-masing Interface, CarService dan ProductService sudah dipisah dan masing-masingnya juga sesuai dan tidak terlalu kompleks.

5.) DIP, sudah benar karena yang di reference di Controller adalah CarService dan si CarService akan mengambil CarServiceImpl dari AutoWired.
</details>