const questions = [
     {
         question: "Which attribute adds a tooltip to an element?",
         options: [
             {text: "src", isCorrect: false },
             {text: "type", isCorrect: false },
             {text: "title", isCorrect: true },
             {text: "style", isCorrect: false }
         ],
         ans: "title"
     },
     {
         question: "A small high speed memory inside CPU is called?",
         options: [
             { text: "RAM", isCorrect: false },
             { text: "Cache", isCorrect: false },
             { text: "ROM", isCorrect: false },
             { text: "Register", isCorrect: true }
         ],
         ans: "Register"
     },
     {
         question: "An attribute in database is also known as _________",
         options: [
             { text: "Row", isCorrect: false },
             { text: "Relation", isCorrect: false },
             { text: "Tuple", isCorrect: false },
             { text: "Field", isCorrect: true }
         ],
         ans: "Field"
     }, {
         question: "DOS was introduced by",
         options: [
             { text: "Microsoft", isCorrect: false },
             { text: "IBM", isCorrect: true },
             { text: "Xerox", isCorrect: false },
             { text: "Bell labs", isCorrect: false }
         ],
         ans: "IBM"
     },

     {
         question: "In React js component's render method ______ can be used to create element ",
         options: [
             { text: "Java Script ", isCorrect: true },
             { text: "UI", isCorrect: false },
             { text: " JSX", isCorrect: true },
             { text: "all of the above", isCorrect: false }
         ],
         ans: ["Java Script ", " JSX"]
     },
    {
        question: "From the following options indicate a correct association of the PROMPT, HEAD and RCPT commands with protocols where they are used?",
        options:[
        {text: "HTTP ", isCorrect: true},
        {text: " SMTP", isCorrect: true},
        {text: "FTP", isCorrect: false},
        {text: "None", isCorrect: false}
        ],
        ans: ["HTTP ", " SMTP"]
    },
    {
        question: "Which of the following coding schemes uses 4-bit code?(captial letters only)",
        ans: "BCD"
    },
    {
        question: "What is the default scope in Node.js application?(small letters only)",
        ans:"local"
    },
    {
        question: "Default number of Tomcat is (numbers only)",
        ans:"8080"
    },
    {
        question: "What server support AJAX?(capital letters only)",
        ans:"HTTP"
    }

]


export default questions;