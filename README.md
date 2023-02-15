<img src="./doc/asserts/easy-logic-banner.png"><img/>
<h3 align="center">Uma solução simples de como criar plugins.</h3>
<h3 align="left">Objetivo</h3>
<p align="left">Sempre que você precisa construir uma custom plugin para evitar o booileplate dentro do seu projeto pense na easy logic, ela devolve uma abstração simples apoiando a construções de suas plugins gradle</p>
<h3 align="left">Exemplo</h3>
<p align="left">Segue um repositório de exemplo, onde podemos encontrar a utilização dos nossos recursos disponível na versão experimental do projeto.</p> 
Repositório utilizando a versão experimental: [Monfu Network - Sample](https://github.com/lnsantos/MonfuNetwork/tree/trunk/build-logic/convention/src/main/kotlin/internal)
<h3 align="left">última versão (experimental)</h3>
```kotlin
  implementation("top.softnepo:easy-logic:0.0.12-experimental")
```
<h3 align="left">Recursos</h3>
<p>Se você deseja adicionar plugins no script você pode utilizar **easyLogicPlugins**, ela retorna todo suporte necessário para plugins simples</p>
```kotlin
    easyLogicPlugins {
        applyPlugin("com.android.library")
        applyPlugin("org.jetbrains.kotlin.android")
    }
```
<p align="left">Se deseja configurar o build de um modulo android gradle, você pode utilizar **easyLogicBuild**, ele providencia para você a estrutura do project android variáveis e métodos simples.</p>
```kotlin
     easyLogicBuild {
        compileSdk = 32
        targetSdk = 32
        onDefaultConfig {
            .minSdk = 21
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            setProguardFiles(listOf("consumer-rules.pro"))
        }
        onCompileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        onKotlinOptions { jvmTarget = "1.8" }
    }
```
<p align="left">Para adicionar as dependencias ganhamos alguns luxos, podemos utilizar a extensão **easyLogicDependency**</p>
<p align="left">**Suporte ao catalog:** carregue o arquivo com as dependencias no settings do projeto, caso esteja em algum conexto diferente</p>
```kotlin
    dependencyResolutionManagement {
       repositories {
          google()
          mavenCentral()
       }
       versionCatalogs.create("libs") { from(files("../gradle/libs.versions.toml")) }
   }
```
