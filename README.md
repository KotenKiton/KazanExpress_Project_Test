# Проект по автоматизации тестирования сайта школы иностранного языка "Puzzle English"
## <a target="_blank" href="https://puzzle-english.com">"Puzzle English"</a>

## :floppy_disk: Содержание:

- <a href="#computer-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#heavy_check_mark-реализованные-проверки-ui">Реализованные проверки UI</a>
- <a href="#heavy_check_mark-реализованные-проверки-api">Реализованные проверки API</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#gear-запуск-тестов-с-выбором-параметров">Запуск тестов с выбором параметров</a>
- <a href="#electric_plug-%D1%81%D0%B1%D0%BE%D1%80%D0%BA%D0%B0-%D0%B2-jenkins">Сборка в Jenkins</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#open_book-интеграция-с-allure-testops">Интеграция с Allure TestOps</a>
- <a href="#open_book-интеграция-с-jira">Интеграция с Jira</a>
- <a href="#film_projector-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Rest-Assured" src="images/logo/Rest-Assured.png">
<img width="6%" title="AllureTestOps" src="images/logo/AllureTestOps.png">
</p>

## :heavy_check_mark: Реализованные проверки UI

- Проверка заголовков на главной странице
- Проверка  наличия кнопки 'Начать заниматься' на главной странице
- Проверка вопросов личного плана
- Проверка ввода неверного email при авторизации
- Проверка ввода неверного пароля при авторизации
- Успешная авторизация

## :heavy_check_mark: Реализованные проверки API

- Проверка избранных комментариев пользователя
- Проверка комментариев на посте
- Проверка комментариев пользователя
- Проверка наград пользователя
- Проверка рейтинга пользователей

## :arrow_forward: Запуск из терминала

Все тесты:

```
gradle clean test
```

API тесты:

```
gradle clean api
```

UI тесты:

```
gradle clean ui
```

## :gear: Запуск тестов с выбором параметров

- ### Параметры
- Тип запускаемых тестов
- Адрес стенда для UI тестов
- Адрес стенда для API тестов
- Назвавние браузера
- Разрешение браузера
- Версия браузера
- Ссылка на удаленный Selenoid

<img title="Jenkins ParamStart" src="images/screenshots/params.png">

Удаленный запуск осуществляется с помощью команды:

```
clean
${TASK}
-Dbrowser=${BROWSER}
-DbaseUrl=${BASE_URL}
-DbaseUri=${BASE_URI}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteDriverUrl=${REMOTE}
```


## :electric_plug: Сборка в Jenkins

### <a target="_blank" href="https://jenkins.autotests.cloud/job/012-bokoffil-diplom1/">Сборка в Jenkins</a>

<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/Jenkins dashboard.png">
</p>  


## :open_book: Allure отчет

- ### Главный экран отчета

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure1.png">
</p>

- ### Страница с проведенными тестами

<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure2.png">
</p>

- ### Страница дашбордов

<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure3.png">
</p>

## :robot: Отчет в Telegram

<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram.png">
</p>

## :open_book: Интеграция с Allure TestOps

<p align="center">
<img title="Allure TestOps" src="images/screenshots/allureTO.png">
</p>

<p align="center">
<img title="Allure TestOps" src="images/screenshots/allureTO1.png">
</p>

## :open_book: Интеграция с Jira

<p align="center">
<img title="Allure TestOps" src="images/screenshots/jira.png">
</p>

## :film_projector: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Видео теста "Проверка вопросов личного плана" представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/016b2f12b9c662dccc8a4077c6476a23.gif">
</p>
