# CSC 207: Text Editor

**Author**: Abigail Ressner

## Revision Log

### Grader comments (for context)

"For an M : You **need to give a reasoning for the runtime of insert** in addition to just the runtime itself.  Your texteditor **needs to pass all autograder tests**. You should be able to pass these tests by ensuring that "delete" deletes the character 1 index to the left of the current cursor position.\
For an E: your texteditor is currently entering 1 character per line. Each entry of a character results in a newline, *while it should all remain on the same line*  You need to **fix your style errors** - unused @param tags for sz, buffer in GapBuffer and unused @param tags for sz, cursor, buffer in SimpleStringBuffer. You can use "mvn checkstyle:check" to see your style errors."

* resolved all checkstyle violations
* fixed `delete()` in SimpleStringBuffer.java to remove the character immediately to the left of the cursor (now passes all autograder tests)
* fixed text rendering issue in TextEditor.java
* added reasoning for the runtime of `insert` ()

## Resources Used

* Java 21.0.6
* Apache Maven 3.9.9
* Visual Studio Code
* [Project 4 instuctions page](https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html)
* Lab 5: Testing Frameworks - for help structuring my test suites
* [Stack Overflow](https://stackoverflow.com/questions/50091802/vs-code-commit-undo) - for instructions on how to undo a commit

### SimpleStringBuffer analysis

Relevant inputs: the character to be added to the buffer\

Critical operations:

* inserting the character
* advancing the cursor
* increasing the size

Mathematical model of `insert` runtime: O(n)

**Justification:**

Since Java strings are immutable, every call to `substring` or use of the `+` operator will create a brand new string, copying all the characters from the original strings. In the worst case, these operations combined are copying *n* characters twice (once for each substring). Then, all `n + 1` characters are copied *again*. Because of this, the runtime is linear, *O(n)*.

## Changelog

Date:   Tue Apr 15 15:00:46 2025 -0500

    add `@Override` annotation to `toString()`

commit f33ee292b996ab671ce805a6dd88a81df8a5d615
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Mon Apr 14 15:31:09 2025 -0500

    fix `delete()`

commit c8681c1c9804954cc957a8a6a5cdb52c436687f3
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Mon Apr 14 15:19:18 2025 -0500

    fix deletion rendering

commit f996674184a0e1b20510bf466f026a4ae98d2baf
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 21:31:06 2025 -0500

commit 5a3a557392f04ef8ea7f4421c852eaa40ffaf7f8
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 20:43:04 2025 -0500

    update README.md

commit 9a08ae30a171b074ace731ba343debf2e884218f
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 20:41:53 2025 -0500

    add text wrapping functionality

commit 2e997ea27163bce84f11839cd6da3bd5f72a7201
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 20:10:47 2025 -0500

    replace manual array copy in `expandBuffer()`

commit fc5f5b6a93163380df68075f480af8a87efaeb73
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 20:09:06 2025 -0500

    fix rendering issues

commit e5c109b0216b6878af69482beb5a3290d4290011
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 20:06:32 2025 -0500

commit 8f36430f5952ba685c6562a33e4d7819c91869e3
Author: Abby Ressner <abbyressner@gmail.com>
Date:   Sun Apr 13 17:30:28 2025 -0500

    correct checkstyle violations

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
