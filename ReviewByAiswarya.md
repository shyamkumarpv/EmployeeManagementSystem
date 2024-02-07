## Code Review

### General Comments

- Project Naming
- Testing not implemented for Exceptions
- Remove unwanted imports
- Didn't add spotless
- Didn't add Jacoco
- Didn't add postman

### model

-  private long Id; -> private Long id;
- You can use ModelMapper instead of builder// entities are same

### service
- Add EntityAlreadyException in AddEmployee