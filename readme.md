# Selenium demo test
* Tests 'https://demo.realworld.io/' site

## Steps to run test suite

### Install dependencies

* Download and install last version of [jdk](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* Download [maven](https://maven.apache.org/download.cgi)
* [Install maven](https://maven.apache.org/install.html)
* Download [ChromeDriver](http://chromedriver.chromium.org/)
* Update env variable 'Path' with the path to ChromeDriver

### Clone project and run tests

* `git clone git@github.com:valeriy-mayboroda/seleniumDemo.git`
* `cd ./SeleniumDemo`
* mvn clean test

### Create report after suite

* mvn allure:serve