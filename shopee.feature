Feature: kiem tra tat pop-up ads

  Scenario Outline: tat pop-up ads
    Given tat pop-up quang cao
    When user nhap <username> va <password>
    Then user navigated to homepage
    When user fill <productname> and click search
    And user choose first item from search result
    And user choose type and size, click add to cart
    Then product will be added to cart

    Examples: 
      | username   |  | password   |  | productname |
      | 0386402996 |  | Matkhau123 |  | quan ao nam |
