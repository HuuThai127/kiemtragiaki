package ktragiuaki;

interface IEmployee {
    void showInfo();
}

class Employee implements IEmployee {
    private String ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private String type;
    private static int employeeCount = 0;
    public Employee(String ID, String fullName, String birthDay, String phone, String email, String type, int employeeCount) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.employeeCount = employeeCount;
    }

    public Employee(String id, String fullName, String birthDay, String phone, String email, String experience) {
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    @Override
    public void showInfo() {
        System.out.println("Employee ID: " + ID);
        System.out.println("Full Name: " + fullName);
        System.out.println("Birthday: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Employee Type: " + type);
    }
    public Employee() {
            employeeCount++;
        }

        public static int getEmployeeCount() {
            return employeeCount;
        }


    }

