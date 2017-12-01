Feature: In this feature we're going to test allo.ua website

  Background:
    Given open homepage "https://allo.ua"

  Scenario: Verify search for specific product
    When type "Sony Xperia XZ F8332 Dual Platinum" into search field
    When click search button
    Then search page with current product should be shown
    Then close browser

  Scenario: Verify image carousel on the home page
    When click right button to slide images to the right
    Then next image should be shown
    When click left button to slide images to the left
    Then previous image should be shown
    Then close browser

  Scenario: Verify contacts page
    When click contact button in the top bar
    Then contact page should be opened
    Then close browser

  Scenario: Verify changing language of the site
    When hover mouse on the change language button
    When select "UA" language
    Then site should be shown in selected language
    Then close browser

  Scenario: Verify checkout
    When type into search field require model "Sony Xperia XZ F8332 Dual Forest Blue"
    When click on the buy button
    Then check that cart page is opened
    Then close browser

  Scenario Outline: Verify social links
    When click on the social "<link>"
    Then social "<site>" should be opened
    Then close browser
    Examples:
      | link     | site     |
      | facebook | facebook |
      | twitter  | twitter  |


  Scenario: Verify blog page
    When click on the blog link
    Then blog page should be opened
    Then close browser

  Scenario Outline: Verify products page in different views
    When hover mouse on the catalog button
    Then catalog menu should be shown
    When select required product type
    Then search page with selected products should be shown
    When change page view with different "<formats>"
    Then page should be shown in "<expected>" format
    Then close browser
    Examples:
      | formats   | expected                          |
      | list      | //ol[@class='products-list']      |
      | pricelist | //div[@class='category-products'] |