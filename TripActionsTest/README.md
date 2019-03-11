## Script to book a hotel for Los Angeles
### How to run
1. git pull `repository_name`
2. import project in eclipse
3. Navigate to `TestBookRoom.java` (src/test/java)--> right click --> Run As --> TestNG Test--> click

### Tools used
1. Selenium to find elements and act on it
2. TestNG to manage test and report generation (test-output --> index.html)
3. maven to install dependencies and build the project.

### Page objects
This script demonstrates use of Page Object pattern with Page Object classes for each Page visited.
This pattern separates test from page functionality and hence makes the test cleaner. Following are the page objects used.
 - `SearchPage`
 - `SearchResultPage`
 - `HotelsDetailPage`
 - `EnterDetailsPage`

### Challenges
1. After entering guest details, the script can not locate the button to click and go to checkout page. Explicitly waiting did not help. It appears that the page apparently has a cover element that is preventing location of button.	
2. Logging could have been better using iListerners.
3. Thread.sleep in SearchResultPage object is clearly not an optimum choice. I tried waiting and fluently waiting for the element but the script did not wait for the page to reload after clicking hotel check box.