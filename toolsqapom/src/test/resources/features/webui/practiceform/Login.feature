Feature: Como usuario final
  necesito ingresar al sistema
  con el fin de cumplir de ingresar al paga home

  Background:
    Given que el usuario final se encuentra en la página del login

  Scenario: Ingreso de un usuario final con login exitoso.
    When el usuario final ingresa user y password validos
    Then el sistema deberá mostrar por pantalla el mensaje de bienvenida

  Scenario: Ingreso de un usuario final con login fallido.
    When el usuario final ingresa user y password invalido.
    Then el sistema deberá mostrar un mensaje de user o password incorrectos

  Scenario: Ingreso de un usuario final con login con campos vacios
    When el usuario final de la click al boton login
    Then el sistema deberá mostrar por pantalla un mensaje debes ingresar los datos

