# CSC 207: Text Editor

**Author**: Abigail Ressner

## Resources Used

+ Java 21.0.6
+ Apache Maven 3.9.9
+ Visual Studio Code
+ [Project 4 instuctions page](https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html)
+ Lab 5: Testing Frameworks - for help structuring my test suites
+ [Stack Overflow](https://stackoverflow.com/questions/50091802/vs-code-commit-undo) - for instructions on how to undo a commit

## Changelog
commit 2f945cf0de3a04e340bc2374913991c07f76c970 (HEAD -> main, origin/main, origin/HEAD)
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Wed Feb 19 23:33:55 2025 -0600

    implement TextEditor and add to README.md

commit ddfd270f7f5ebf3900f66daabe6c084750ac00d1
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Wed Feb 19 22:43:05 2025 -0600

    implement GapBuffer test suite and fix methods

commit 5d0e1d093cb87a17c450a7771d04eb102f8bef23
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Wed Feb 19 21:58:48 2025 -0600

    add javadoc comments

commit 15c40aa8f9f017e4d42aca4bd50b0e2b7d93fc70
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Wed Feb 19 21:50:55 2025 -0600

    implement SimpleStringBuffer test suite and fix deletion method

commit adaf22c33d48fa8b2801bb50dd7caea0920bfd5f
Merge: 30247d8 0c8c7ba
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Tue Feb 18 22:17:05 2025 -0600

    Merge remote-tracking branch 'origin/main'

commit 30247d85adfeb4b46f300f6d85a87eadbbf05872
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Tue Feb 18 10:03:45 2025 -0600

    implement GapBuffer class

commit 0c8c7ba74a9a1ea54401d9eac8d6a14d868eeca2
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Mon Feb 17 18:54:20 2025 -0600

    Update README.md

commit eec590e44577cbcfaecb31bb58e6fc32ea0b3e23
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Mon Feb 17 18:44:14 2025 -0600

    implement SimpleStringBuffer class

commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:40:05 2025 -0600

    Project files

commit 02dc92144ecc088bcefb4a9798df0934efe300c1
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:39:53 2025 -0600

    initial commit
(END)

### SimpleStringBuffer analysis
Relevant inputs: the character to be added to the buffer \
Critical operations:
- inserting the character
- advancing the cursor
- increasing the size
Mathematical model of `insert` runtime: T(n) = 1 \
`insert` is O(1)