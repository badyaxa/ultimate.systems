package ultimate.systems.study.init;

import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ultimate.systems.study.model.Student;
import ultimate.systems.study.model.Teacher;
import ultimate.systems.study.service.StudentService;
import ultimate.systems.study.service.TeacherService;

@Component
public class DataInitializer {
    private final StudentService studentService;
    private final TeacherService teacherService;

    public DataInitializer(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @PostConstruct
    public void inject() {
        List<String> first = List.of("Alicia", "Jadyn", "Ivy", "Naomi", "Evelyn", "Kamora",
                "Jayla", "Kelsie", "Lucille", "Kyra", "Lyla", "Elsa", "Sabrina", "Dylan", "Luna",
                "Jenna", "Madeleine", "Jordyn", "Kelsey", "Melody", "Allisson", "Rosa", "Delaney",
                "Olive", "Aryana", "America", "Katelyn", "Lauryn", "Regan", "Nathalie", "Bailey",
                "Tiffany", "Micaela", "Hana", "Joselyn", "Miah", "Elsie", "Helena", "Alice",
                "Camille", "Alessandra", "Isabell", "Nataly", "Maritza", "Adeline", "Saige",
                "Mariah", "Aracely", "Brisa", "Abril", "Tessa", "Neveah", "Addisyn", "Angel",
                "Madisyn", "Armani", "Sharon", "Kaylin", "Kaley", "Amiah", "Jase", "Jermaine",
                "Brock", "Cassius", "Enzo", "Roger", "Muhammad", "Christopher", "Braden",
                "Parker", "Brendan", "Taylor", "Fabian", "Ben", "Jordyn", "Alexis", "Nicolas",
                "Jamal", "Leonel", "Josue", "Dorian", "Dereon", "Rishi", "Reese", "Kendall",
                "Gary", "Randy", "Mathew", "Dillan", "Caden", "Alexander", "Jonathon", "Leo",
                "Rashad", "Benjamin", "Conor", "Dawson", "Manuel", "Gavyn", "Chaim", "Alden",
                "Matias", "Jasiah", "Jaylen", "Brent", "Jaime", "Darnell", "Scott", "Jonas",
                "Osvaldo", "Silas", "Craig", "Mason", "Adam", "Armani", "Leandro", "Ayaan",
                "Coby", "Jacob", "Brycen");
        List<String> last = List.of("Moon", "Kirk", "Roberts", "Gilbert", "Terrell", "Hinton",
                "Estes", "Atkins", "Warren", "Odom", "Baldwin", "Ritter", "Carson", "Beasley",
                "Sherman", "Hester", "Bean", "Coffey", "Donaldson", "David", "Schmitt", "Tucker",
                "Richmond", "Zuniga", "Nash", "Haley", "Moody", "Dalton", "Blanchard", "Benton",
                "Grimes", "Mckee", "Boyle", "Bowen", "Farley", "Hickman", "Stanley", "Gill",
                "Villa", "Montoya", "Hawkins", "Kaiser", "Vega", "Anthony", "Jefferson", "Bush",
                "Dawson", "Love", "Sweeney", "Cross", "Powell", "Conner", "Jarvis", "Mills",
                "Sandoval", "Parrish", "Gillespie", "Mcfarland", "Shepard", "Cortez", "Baker",
                "Mcdonald", "Olsen", "Scott", "Arias", "Black", "Mcintyre", "Rhodes", "Mahoney",
                "Mathis", "Payne", "Bowers", "Meyers", "Huerta", "Santos", "Benson", "Cordova",
                "Reed", "Gray", "Glass", "Rice", "Charles", "Manning", "Espinoza", "Navarro",
                "Robinson", "Wallace", "Whitehead", "Bradley", "Cantrell", "Rosario", "Chung",
                "Key", "Dunn", "May", "Mcdowell", "Moyer", "Cisneros", "Rasmussen", "Robertson",
                "Dennis", "King", "Conley", "Hunt", "Walters", "Murphy", "Edwards", "Wells",
                "Bass", "Greer", "Daniel", "Sellers", "Sloan", "Johns", "Austin", "Koch", "Haas",
                "Chambers", "Ware", "Lara");
        List<String> email = List.of("daija.kuvalis@king.com", "hoconnell@beahan.com",
                "beer.piper@shields.com", "keegan.berge@oconnell.com", "khudson@yahoo.com",
                "astoltenberg@glover.com", "monica83@hotmail.com", "schulist.cynthia@huels.com",
                "dfriesen@hotmail.com", "jstehr@gmail.com", "janice.littel@hotmail.com",
                "stacy.schaefer@pfannerstill.biz", "schuster.adaline@yahoo.com",
                "narciso34@hotmail.com", "aliya.runolfsdottir@gmail.com", "rtorphy@gmail.com",
                "hillary40@yahoo.com", "vernie.stanton@gmail.com", "lucas79@hotmail.com",
                "gabriel33@skiles.com", "considine.kip@yahoo.com", "wbartell@yahoo.com",
                "hillary01@gulgowski.org", "price.streich@yahoo.com", "obode@gulgowski.com",
                "clotilde.quigley@ohara.com", "koepp.otis@hotmail.com", "soledad95@stark.info",
                "ruthe.nicolas@gmail.com", "maximilian.ullrich@hotmail.com",
                "stoltenberg.jose@hammes.org", "reanna.damore@bosco.com",
                "bailey.ruthie@hotmail.com", "tanya82@yahoo.com", "zboncak.raul@hotmail.com",
                "berry.haley@brekke.com", "dayna.yost@price.com", "katarina.effertz@kohler.com",
                "nicole64@hotmail.com", "neal17@gmail.com", "jackson.effertz@gmail.com",
                "desmond.quigley@yahoo.com", "gerlach.christiana@flatley.com",
                "mossie17@bradtke.net", "tremblay.glenna@kautzer.org", "elian31@schuppe.info",
                "wweimann@gmail.com", "nfadel@wiegand.com", "demarcus80@mcclure.org",
                "aryanna.mcclure@gmail.com", "lempi89@yahoo.com", "derek.leffler@hyatt.net",
                "katlyn64@harber.org", "predovic.sydni@morar.com", "betty.jerde@yahoo.com",
                "zulauf.shanelle@mertz.com", "buck11@mcclure.com", "rjacobson@cartwright.com",
                "schneider.jana@yahoo.com", "bogisich.bradley@hotmail.com",
                "hettinger.velda@yahoo.com", "fmckenzie@hotmail.com", "fhills@gmail.com",
                "lyost@oreilly.com", "rrogahn@gmail.com", "margret09@gmail.com",
                "sziemann@friesen.net", "annabell36@metz.org", "windler.deshawn@ledner.com",
                "monroe.barton@cormier.com", "fcrooks@funk.info", "luciano.hagenes@schiller.com",
                "janiya.dooley@mosciski.com", "henry68@satterfield.com", "zdavis@osinski.com",
                "monique.kutch@kovacek.org", "dubuque.arvid@gmail.com",
                "jameson.schmeler@yahoo.com", "lhowe@funk.com", "belle.langosh@yahoo.com",
                "velma.littel@smitham.com", "nils.mckenzie@hotmail.com",
                "amara.mosciski@weimann.com", "kenton.koepp@kunze.com", "ryleigh40@brown.net",
                "schaefer.imelda@yahoo.com", "qpurdy@walsh.org", "monahan.kacie@kutch.com",
                "langworth.jessyca@hotmail.com", "hessel.vladimir@yahoo.com",
                "stokes.sven@terry.info", "kendrick37@gmail.com", "tracy65@rohan.biz",
                "crona.christelle@ernser.com", "lamar07@eichmann.com", "wdietrich@ferry.net",
                "nader.kitty@kerluke.info", "elody.walsh@yahoo.com", "marguerite26@beer.info",
                "dakota07@yahoo.com", "jerde.grayson@yahoo.com", "ally.reichel@hotmail.com",
                "spinka.floyd@yahoo.com", "romaguera.ezra@ritchie.com", "orpha.hermann@gmail.com",
                "kmoore@hotmail.com", "charlotte73@altenwerth.biz", "ghartmann@yahoo.com",
                "wilma13@klein.com", "abshire.ardith@yahoo.com", "fcollier@kassulke.com",
                "merl17@crist.com", "herzog.madilyn@fay.com", "earlene.gusikowski@cassin.net",
                "arturo00@gmail.com", "katlynn79@yahoo.com", "zelda.kub@yahoo.com",
                "ankunding.angela@yahoo.com", "gerardo.heller@yahoo.com", "deion68@yahoo.com",
                "chessel@yahoo.com", "parisian.marques@hauck.com", "dach.remington@lakin.org",
                "konopelski.anderson@hirthe.biz", "mdibbert@hotmail.com",
                "dorthy.schaefer@oconnell.org", "freinger@hotmail.com", "arussel@heller.biz",
                "bweissnat@romaguera.com", "tiffany.jacobson@schaefer.com", "smante@hotmail.com",
                "russ.dicki@okon.org", "strosin.eli@hoeger.com", "ronny.shanahan@stracke.info",
                "esmeralda.kozey@west.biz", "lori.wilderman@gmail.com",
                "santa.quitzon@schaefer.info", "alessandra.leffler@zboncak.info",
                "ykilback@gmail.com", "adonis.powlowski@hotmail.com", "curt98@gmail.com",
                "bdach@hotmail.com", "raquel.buckridge@gmail.com", "jeanne08@swift.com",
                "cruickshank.terry@yahoo.com", "emmanuel39@gmail.com", "nbatz@moen.org",
                "haskell04@bosco.biz", "swaniawski.lonny@gmail.com",
                "mcclure.kristin@hotmail.com", "dmante@gmail.com", "erwin.kovacek@lang.com",
                "rosalyn20@boyer.info", "qsporer@rowe.com", "korn@pfeffer.com",
                "edna.turcotte@walker.info", "otha12@wisoky.net", "ybrown@morar.com",
                "cordell19@stanton.com", "lbergnaum@hotmail.com",
                "everett.stoltenberg@thompson.com", "wroob@yahoo.com", "pfeffer.roma@gmail.com",
                "mkshlerin@hotmail.com", "dillan27@zemlak.biz", "darrin.waters@gmail.com",
                "kyle.littel@rau.com", "ajohns@beier.net", "darryl10@morar.com",
                "marcelina.fadel@cole.com", "dskiles@grant.com", "hane.elliot@huels.com",
                "klocko.julio@stroman.com", "bradtke.alford@lynch.com", "bailey.lizzie@gmail.com",
                "maegan03@lind.net", "tstroman@denesik.net", "marks.luciano@yahoo.com",
                "noelia53@hotmail.com", "qohara@dibbert.net", "cormier.keaton@raynor.info",
                "alyce75@ernser.com", "xdonnelly@gmail.com", "gpagac@von.com",
                "klein.lorenza@gmail.com", "tania15@gmail.com", "marks.arlie@lakin.com",
                "dewitt76@heaney.com", "alphonso.schinner@mraz.com", "ilowe@veum.info",
                "johnston.floy@yahoo.com", "katharina.satterfield@yahoo.com",
                "tiffany51@hotmail.com", "samantha.connelly@hotmail.com",
                "berge.destinee@bechtelar.com", "pagac.ocie@gmail.com",
                "maritza.kovacek@tillman.com", "kulas.frank@gmail.com", "nstroman@hotmail.com",
                "melyna03@yahoo.com", "ilene.murray@yahoo.com", "gina.heathcote@jakubowski.org",
                "chandler24@yahoo.com", "bkeebler@yahoo.com", "uriah.feil@hotmail.com",
                "elmira88@gmail.com", "reynolds.ivy@gmail.com", "rory72@bergstrom.com",
                "victoria.rath@kuhn.org", "hettie.schowalter@raynor.com",
                "brandt.casper@towne.biz", "qhowell@yahoo.com", "tblick@yahoo.com",
                "cynthia85@yahoo.com", "duncan82@kautzer.com", "bhamill@hegmann.net",
                "carissa.kassulke@gmail.com", "bo.bailey@hoppe.info", "rasheed03@gmail.com",
                "ryan.reinhold@cremin.com", "bobby44@yahoo.com", "effie17@gmail.com",
                "kristoffer.jakubowski@hotmail.com", "wmckenzie@hotmail.com",
                "crooks.kayla@terry.biz", "katheryn.durgan@little.com",
                "considine.hulda@hudson.com", "leonie.dietrich@yahoo.com", "larson.mya@grady.net",
                "roslyn.goodwin@kuhic.org", "stark.russ@bednar.com", "zcole@gmail.com",
                "jaqueline47@hotmail.com", "zola.weissnat@hammes.com", "rey13@hotmail.com",
                "tstark@torp.com", "bosco.sherwood@hotmail.com", "osvaldo62@hotmail.com",
                "reanna.konopelski@prohaska.com", "jones.joseph@gmail.com",
                "gislason.jamel@gorczany.com", "gabriel16@hotmail.com",
                "fanny.schamberger@hotmail.com", "lennie.rempel@muller.com", "kendra98@yahoo.com",
                "marjolaine.thompson@abshire.com", "elinor.kemmer@buckridge.org",
                "avery41@zboncak.com", "bahringer.enoch@hotmail.com", "hudson.hulda@yahoo.com",
                "geoffrey.mcdermott@yahoo.com", "schimmel.keaton@gmail.com",
                "dare.urban@yahoo.com", "fjohns@gmail.com", "xshields@yahoo.com",
                "vfeil@armstrong.com", "bradtke.jacinthe@gmail.com", "katarina26@gmail.com",
                "thomas.johnston@schmidt.com", "hackett.lauryn@lakin.com", "kenny83@yahoo.com",
                "ayla.reichert@prohaska.com", "ewunsch@lynch.org", "kunze.ramona@kling.biz",
                "kertzmann.isadore@yahoo.com", "sfahey@hotmail.com", "rau.juliana@gmail.com",
                "mraz.ollie@schuster.com", "loren25@yahoo.com", "jayson.herzog@hotmail.com",
                "annabel.metz@hartmann.com", "francisca.haley@gmail.com", "okon.vesta@yahoo.com",
                "margret.terry@gmail.com", "missouri.casper@thiel.com", "aileen.mante@yahoo.com",
                "elian.lueilwitz@casper.com", "witting.rashad@gmail.com", "aiden.marvin@gmail.com",
                "percival.hermann@abshire.net", "doyle.pearline@terry.com",
                "armando.thompson@hotmail.com", "skuhn@okon.com", "ernestina.hahn@dare.org",
                "florian.dach@stehr.net", "tatyana41@boehm.com", "micheal54@gmail.com",
                "lilla.grady@yahoo.com", "turcotte.marion@turcotte.com", "korey45@hotmail.com",
                "reynolds.josefa@yahoo.com", "nikolaus.jude@gmail.com", "mireya40@gmail.com",
                "bgrant@yahoo.com", "swaniawski.terry@reichert.com", "cmarvin@gmail.com",
                "chet44@hotmail.com", "vcollier@waelchi.com", "letitia.klein@gmail.com",
                "qwalsh@hermann.com");
        List<String> subject = List.of("Accounting", "Art History", "Arts and Humanities",
                "Biology", "Business and Management", "Chemistry", "Classical Studies",
                "Combined Studies", "Computing and IT", "Counselling", "Creative Writing",
                "Criminology", "Design", "Early Years", "Economics", "Education",
                "Electronic Engineering", "Engineering", "English", "Environment",
                "Film and Media", "Geography", "Health and Social Care", "Health and Wellbeing",
                "Health Sciences", "History", "International Studies", "Languages", "Law",
                "Marketing", "Mathematics", "Mental Health", "Music", "Nursing and Healthcare",
                "Philosophy", "Physics", "Politics", "Psychology", "Religious Studies", "Science",
                "Social Sciences", "Social Work", "Sociology", "Software Engineering",
                "Sport & Fitness", "Statistics");
        List<String> direction = List.of("Advanced Technology", "Apprenticeships",
                "Arts and Design", "Business", "Community and Social Services",
                "Construction and Skilled Trades", "Corporate Training", "Culinary",
                "Hospitality and Recreation", "Environmental and Applied Sciences",
                "General", "Health Sciences", "Media and Communications",
                "Public Safety and Legal Studies", "Transportation");
        Random random = new Random();
        for (int i = 1; i <= 15; i++) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(first.get(random.nextInt(first.size())));
            teacher.setLastName(last.get(random.nextInt(last.size())));
            teacher.setAge(18 + random.nextInt(20));
            teacher.setEmail(email.get(random.nextInt(email.size())));
            teacher.setSubject(subject.get(random.nextInt(subject.size())));
            teacherService.save(teacher);
        }
        for (int i = 1; i <= 80; i++) {
            Student student = new Student();
            student.setFirstName(first.get(random.nextInt(first.size())));
            student.setLastName(last.get(random.nextInt(last.size())));
            student.setEmail(email.get(random.nextInt(email.size())));
            student.setDirection(direction.get(random.nextInt(direction.size())));
            studentService.save(student);
        }
    }
}
