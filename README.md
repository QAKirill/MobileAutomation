# Проект по автоматизации тестовых сценариев для приложения Wikipedia
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#jenkins)
- [Пример Allure-отчета](#allure)
- [Уведомления в Telegram с использованием бота](#telega)
- [Видео примера запуска тестов в Selenoid](#Видео-запуска-тестов-в-Selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="attach/Logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="attach/Logo/Java.svg">
<img width="6%" title="Selenide" src="attach/Logo/Selenide.svg">
<img width="6%" title="Selenoid" src="attach/Logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="attach/Logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="attach/Logo/Gradle.svg">
<img width="6%" title="JUnit5" src="attach/Logo/JUnit5.svg">
<img width="6%" title="GitHub" src="attach/Logo/GitHub.svg">
<img width="6%" title="Jenkins" src="attach/Logo/Jenkins.svg">
<img width="6%" title="Appium" src="attach/Logo/Appium.svg">
<img width="6%" title="Browserstack" src="attach/Logo/Broserstack.svg">
</p>

## 🏁 Реализованные проверки:

### При запуске локально (local) на эмуляторе:

- Проверка появления результатов поиска при выдаче
- Проверка 4 стартовых страниц wiki
- Проверка присутствия кнопки логина на странице при переходе через edits
- Проверка поиска конкретной статьи
- Проверка добавления и удаления языка

### При запуске удаленно (remote) на Browserstack:

- Проверка появления результатов поиска при выдаче
- Проверка поиска
- Проверка выдачи валидной статьи при поиске
- Добавление языка

## :arrow_forward: Запуск автотестов

### Запуск тестов на локальном эмуляторе
```
gradle clean emulation_test -DdeviceHost=emulation
```
### Запуск тестов на удаленном устройстве через Browserstack
```
gradle clean ios_test -DdeviceHost=ios
gradle clean android_test -DdeviceHost=android
```
При выполнении команды, тесты запустятся удаленно в <code>Browserstack</code>.

## <img name="jenkins" src="attach/Logo/Jenkins.svg" title="Jenkins" width="4%"/> <a href="https://jenkins.autotests.cloud/job/21-Yejik-java-TinkoffWebTests" target="blank">Сборка в Jenkins</a>

<p align="center">
<img title="Jenkins Build" src="attach/Reports/JenkinsBuild.png">
</p>

### Параметры сборки

* <code>PLATFORM</code> – мобильная платформа, на которой выполняются тесты. По-умолчанию - <code>android</code>.

## <img name="allure" src="attach/Logo/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="https://jenkins.autotests.cloud/job/21-Yejik-java-MobileAutomation/9/allure/" target="_blank">Пример Allure-отчета</a>

Содержание Allure-отчета:
* Шаги теста;
* Page Source;
* Видео выполнения автотеста.

### Overview

<p align="center">
<img title="Allure Overview" src="attach/Reports/allureReport.png">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="attach/Reports/ResultTest.png">
</p>

<a id="movie"></a>
## <img alt="Browserstack" height="25" src="media/logo/Browserstack.svg" width="25"/></a> Видеопример выполнения теста Browserstack

____
<p align="center">
<img title="Browserstack Video" src="media/screen/ErrorMovie.gif" width="350" height="350"  alt="video">   
</p>
