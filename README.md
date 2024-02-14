# Fatih Raditya Pratama - 2206083520
<details> 
<summary>Reflection-1</summary>

Menurut saya selama tutorial ini, sudah memenuhi standar clean code, akan tetapi untuk secure coding sendiri saya masih kurang paham, namun sepertinya sudah aman, 
karena saat membuat product itu yang diminta jelas, String dan int, mungkin masih ada celah tapi saya masih belum terlalu paham terkait cara melakukan secure coding itu sendiri.

Mungkin kekurangan dari code ini adalah, code ini belum melakukan prevensi jika quantity dari Product nya < 0. Sehingga Product yang ada bisa minus.
</details>
<details>
<summary>Reflection-2</summary>

## 1. 
Membuat unit test sangat membantu dalam memahami program lebih jauh lagi, menurut saya sendiri membuat unit test itu lumayan menyenangkan, untuk berapa banyak unit test
yang diperlukan, kita perlu membuat unit test untuk setiap fitur yang kita buat dalam program kita serta kemungkinan-kemungkinan yang berkaitan dengan fitur yang kita
buat tadi. Contohnya dalam hal ini adalah test untuk melihat apakah Product yang sudah di delete masih ada dalam productRepository atau tidak.
## 2. Saya masih kurang mengerti bagian functional test ini.
</details>

<details>
<summary>Reflection-3</summary>

## 1.
Tadi code quality Issue yang saya alami hanya masalah dead code saja. Untungnya tidak ada yang aneh-aneh. Strategi saya dalam menghadapi code quality issue tinggal melakukan deletion
terhadap code-code yang tidak saya pakai. Selain itu, ada juga import-import yang tidak terpakai dan saya delete.

## 2.
Ya, code saya sudah ada automated build script yang akan melakukan continous change thd codebase nya. Tes-tes nya juga sudah cukup memadai, sehingga harusnya mencukupi. Selain itu, deployment
nya juga sudah automatic dengan menggunakan github actions.
</details>