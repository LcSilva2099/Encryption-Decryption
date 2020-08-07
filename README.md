# Encryption-Decryption
Encryption-Decryption project for the Hyperskill Java course

Simple cryptography program. It receives command line arguments. Examples:

Example 1

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

This command get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

Example 2

Input:

java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode

Output:

\jqhtrj%yt%m~ujwxpnqq&

Example 3

Input:

java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

Output:

Welcome to hyperskill!

Example 4:

Input:

java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc

Output:

Bjqhtrj yt mdujwxpnqq!

Example 5:

Input:

java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec

Output:

Welcome to hyperskill!
