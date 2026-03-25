

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImp studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudentId(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {

        Student existing = studentService.getStudentId(id);

        if(existing == null) {
            throw new RuntimeException("Student not found");
        }

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());

        studentService.saveStudent(existing);

        return existing;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Deleted Successfully";
    }
}

