Feature: Como Administrador del sistema
  necesito ingresar al sistema nuevos usuarios
  con el fin que usuarios nuevos puedan ingresar al sistema.


  Scenario: Ingreso de un usuario con todos los campos.
    Given que el Administrador se encuentra en la formulario de ingreso de usuario
    When el Administrador ingresa todos los campos y confirma la acción
    Then el sistema deberá mostrar por pantalla el registro del usuario ingresado.



