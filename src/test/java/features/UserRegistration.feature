Feature: User Registration
		I want to check that the user can register in our e-commerce website.
		
	Scenario Outline: User registration
	Given the user in the home page
	When I click on registration link
	And I entered "<firstName>","<lastName>","<email>","<password>"
	Then The registration page displayed successfully
	
	Examples:
	| firstName | lastName | email | password |
	| eslam1 | gamal | ajzzs@xnn.cd | 2145214 |
	| eslam2 | gamal2 | jhsxx@acq.cs | 54785214 |