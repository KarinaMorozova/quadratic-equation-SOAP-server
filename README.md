# Тестовое задание

## 1 часть SOAP web-сервис
Разработать SOAP сервис "Решение квадратного уравнения" вида A*X^2+B*X+C=0, через дискриминант.
В запросе передаются переменные A, B, C, например:
**<request>
    <a>3</a>
    <b>4</b>
    <c>1</c>
</request>**

В ответ сервис возвращает общий вид уравнения и найденные корни, например:
**<response>
    <formula>3x^2+4x+1=0</formula>
    <D>0</D>
    <x1>0</x1>
    <x2>0</x2>
</response>**

В случае если дискриминант меньше нуля создается исключение. У сервиса должно автоматически 
генерироваться описание в формате wsdl с xsd-схемами. В запросе элементы **a,b,c** - являются обязательными.
В ответе элемент "**x2**" может отсутствовать, если дискриминант равен 0.
В случае исключения ответ с ошибкой должен содержать помимо сообщения об ошибке, элементы "**formula, D**"

**-------------------------------------------------------------------------------------------------------**

## Web-сервис написан на Spring Boot c помощью системы сборки Maven и сервера приложений Tomcat
## После запуска приложения описание в формате wsdl c xsd-схемами можно найти по адресу
## http://localhost:8080/ws/coeffs.wsdl

### Сборка Spring Boot проекта с Maven

Чтобы иметь возможность запускать приложение Spring Boot, вам необходимо сначала его собрать. Чтобы собрать 
и упаковать приложение Spring Boot в один исполняемый файл Jar с помощью Maven, используйте команду ниже. 
Вам нужно будет запустить его из папки проекта, которая содержит **файл pom.xml**.

**maven package**

или вы также можете использовать

**mvn install**

### Запустите приложение Spring Boot с помощью команды java –jar**

Чтобы запустить приложение Spring Boot из командной строки в окне терминала, вы можете воспользоваться 
командой java -jar. Это при условии, что ваше приложение Spring Boot было упаковано в виде исполняемого 
файла JAR. 

java -jar target/quad-server-0.0.1-SNAPSHOT.jar

### Запустите приложение Spring Boot с помощью Maven

Вы также можете использовать плагин Maven для запуска приложения Spring Boot. Используйте приведенный 
ниже пример для запуска приложения Spring Boot с плагином Maven:

mvn spring-boot:run

**-------------------------------------------------------------------------------------------------------**

### Проверка работы сервиса

Проверить web-сервис можно с помощью открытой утилиты SOAPUI с сайта https://www.soapui.org/ (через VPN). 
В меню открывшегося окна приложения выбрать пункт SOAP в верхнем меню, ввести название и ссылку на wsdl-файл:

http://localhost:8080/ws/coeffs.wsdl

После этого система построит xml-схему, в которой будет предложенно ввести коэффициенты приложения a, b, с. 
По нажатию кнопки с зеленой стрелкой в левом верхнем углу приложение выдаст ответ в xml-формате с выводом 
общего вида, дискриминанта и корней уравнения. Ответ можно будет увидеть в правой части окна на вкладке XML. 