# Super Locker Robot

* Super Locker Robot store bag and return receipt
    * Given Super Locker Robot with lockers
    * When store a bag
    * Then get a receipt

* Super Locker Robot store bag to first locker when two lockers' vacancy rate is equal
    * Given Super Locker Robot with same vacancy rate lockers
    * When store a bag
    * Then bag should be stored in first locker
    
* Super Locker Robot store bag to the Higher Vacancy Rate locker
    * Given Super Locker Robot with different vacancy rate lockers
    * When store a bag
    * Then bag should be stored in the higher vacancy rate locker

* Super Locker Robot cannot store bag when lockers are all full
    * Given Super Locker Robot with full lockers
    * When store a bag
    * Then bag cannot be stored

* Super Locker can get bag using valid receipt
    * Given there is a valid receipt
    * When get a bag from super locker robot
    * Then I can get the bag

* Super Locker cannot get bag using invalid receipt without locker info
    * Given there is an invalid receipt without locker info
    * When get a bag from super locker robot
    * Then I cannot get the bag
    
* Super Locker cannot get bag using invalid receipt with locker info
    * Given there is an invalid receipt with locker info
    * When get a bag from super locker robot
    * Then I cannot get the bag
    
* Super Locker cannot get bag using reused receipt with locker info
    * Given there is an reused receipt
    * When get a bag from super locker robot
    * Then I cannot get the bag