# Java Security Trials

Programming playground for my trials on cryptography and security in Java.

| Sr No.| Experiment  | Source code Link  | Reference |
| ---   | ---         | ---               | ---       |
| 1.    | Cracking Random number Generator |[Link](https://github.com/Shashi-Bhushan/java-security-trials/blob/master/src/main/java/in/shabhushan/crypto/random/BrokenRandom.java)| [Cracking Random Number Generator](https://jazzy.id.au/2010/09/20/cracking_random_number_generators_part_1.html) |

## Notes on few common Topics

### Hashing
It is a process to convert a message to a fixed length random bytes. Bytes of hash output are usually denoted in [Hex or Base 64 notation](https://crypto.stackexchange.com/questions/50481/looking-at-hash-output-is-base64-encoding-in-any-way-better-than-hex-encoding).
- When hashing is used for non security purpose, consider using MD5 or SHA family of hashes.
- When hashing is used for security purpose, consider using cryptographically secure hashes like BCrypt or Scrypt or [Argon2](https://www.password-hashing.net/#argon2)

Hash function should have these 4 properties - Deterministic, irreversible, high entropy and collission resistance.

AFAIK, Java natively supports only [PBKDF2](https://github.com/Shashi-Bhushan/java-security-trials/blob/master/src/main/java/in/shabhushan/crypto/hashing/PasswordBasedKeyDerivationFunction.java), but others can be added via libraries.
