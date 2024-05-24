<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.

1. I edited the mainscreen.html view file. 
2. In this file, I add styling coding to lines 16-49 (optional). In this code you will see several things I did to make the website look pretty cool.
3. On line 14, I changed the store name to "Stephen's Furniture Store." as required. 
4. Also, changed header 1 on line 56 to the same thing. 
DONE WITH PART C!

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
1. Created a new about.html. This html gives a brief basic description of the company. 
2. Added a return to mainscreen button in this page to take us back to the main page via the mainscreen controller. 
3. Created a new java class controller titled "AboutController"
4. In the new AboutController I pretty much only included a GetMapping with a showpage method to return the page. This controller does not really have to do anything. Alternatiely I could have also just added this to the maincontroller. 
5. Finally, in the mainscreen.html code, I added an about button mapped to the aboutcontroller to return the about page. Lines 56-57.

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
Added sample data to the bootstrapdata class. 

1. In the BootStrapData class, (Lines 41-110) I added all the sample data. I included 4 outsourced parts, 1 insourced part, and 5 products. 
2. Lines 42 and 92 check to see that the parts and product count are at 0 before adding the sample data. 
3. Lines 44-80 I added 4 outsourced parts (each was set with a company name, part name, id, inventory and price). I also added each to the repository. 
4. Lines 81-92 I added 1 insourced part. I also added this part to the repository. 
5. Lines 97-110 I added 5 products from the Product class following the constructor. I also saved these products to the repository. 

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.
added buy now button to the mainscreen.html
1. Created a new buyproductcontroller class from scratch.  
   2. This controller is to handle the buy now button request from the mainscreen.html (will add button next)
   3. This controller has autowired productrepository object to handle inventory to decrease it by one. 
   4. This controller also incorporates methods to obtain the productId.
   5. This controller also has a option product that find the id to take care of any requests of something that may not be in the database. 
   6. I also added logic to map the purchase to a success or error message after purchasing. 
7. In the mainscreen:
   8. Lines 124-127, I added a buynow button.
      9. This button is mapped to the controller above.
      10. This button is set to POST request to update the product.
      11. This button is also passes through a hidden input so that the product id will go to the controller. 
12. I created a new purchaseError.html from scratch. 
13. I created a new purchaseSuccess.html from scratch. 

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

1. In the Part.java class: 
   2. Lines 31-34 I added the additional fields for maximum and minimum inventory. 
   3. Line 45. Added new fields to the constructor for part
   4. Lines 48-49: Added values to constructors. 
   5. I repeated steps 3 and 4 above for the Part constructor below it starting at line 52.
   6. Lines 93-107: I added getters and setter to the new maxInv and minInv fields.
7. In the BootStrapData class: 
   8. Adding all of the max and min values to sample part data (lines 55-56, 64-65, 72-73, 80-81, 97-98)
9. In the InhousePartForm: 
   10. Lines 24-29: Added the text inputs for min and maxInv field for new in house parts. 
11. In the OutsourcedPartForm: 
    12. Lines 25-29: Added the text inputs for minInv and maxInv fields for new outsourced parts. 
13. Back in the Part.java class, in lines 117-119 I added an isInventoryValid() method. 
14. In the AddOutsourcedPartController.java:
    15. In lines 43-47 I added a validation check to see that the new input is valid. If not, it writes an error.
16. In the AddInhousePartController.java:
    17. In lines 43-47 I added the validation check to see that the new input is valid. If not, it writes an error. 
   
H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

1. In the AddInhousePartController: 
   2. Lines 44-49: Commented out old code for reference. Added an if else logic to give a display an error message if the inventory gets too low or too high
3. In the AddOutsourcedPartController.java:
   4. In lines 45-51: Commented out old code for refence. Added an if else logic to give a display an error message if the inventory gets too low or too high. 
5. In the EnufPartValidator.java class
   6. Lines 36-47: added a statement that will check if any of the parts for the product would go below there minimum if a particular product was made. Added an error message as well. 
I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

1. In the PartTest.java file:
   2. Lines 160-178 added two unit tests. One for minInv and one for maxInv. 

J.  Remove the class files for any unused validators in order to clean your code.


K.  Demonstrate professional communication in the content and presentation of your submission.