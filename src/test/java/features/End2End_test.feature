Feature: Automated E2E tests
		Descraption: The Purpose of this feature is test E2E integration.

Scenario Outline: Customer place an order by purchasing an item from search
		Given user is on home page
		When he search for "<productName>"
		And choose to buy two items
		And moves to checkout cart and enter personal details on checkout page and place the order
		Then he can view the order and print the invoice
		
Examples:
		|productName|
		|Apple MacBook Pro 13-inch|
