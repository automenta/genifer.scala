package genifer

class Memory {
	
//;;;; ***** Memory systems
//;;;; Currently the memory is just a simple list of all items, stored in *generic-memory*.

//(defvar *generic-memory*)
//(defvar *memory-size*)
//(defvar *newly-added*)
//(defvar new-rule)

//;;; **** Add a clause to memory
//;;; TODO:  label, and the stack from abduction
//(defun add-to-memory (clause label)
//  ;; check if the clause is already in memory -- this may be time-consuming.
//  (dolist (item *generic-memory*)
//    (if (equal clause (slot-value item 'clause))
//      (return-from add-to-memory)))     ; if so, exit
//  ;; if not in memory, add it
//  (if (is-ground clause)
//    (add-fact-to-mem clause)
//    (add-rule-to-mem clause)))

//;;; **** Add a fact to Generic Memory
//(defun add-fact-to-mem (fact &optional tv justifies justified-by)
//  (if (null tv)
//    (setf tv (cons 1.0 1.0)))          ; default TV
//  (****DEBUG 1 "adding fact to memory: ~a" fact)
//  ;; create an object
//  (setf new-fact (make-instance 'fact-item
//                          :fact         fact
//                          :id           *memory-size*
//                          :tv           tv
//                          :justifies    justifies
//                          :justified-by justified-by))
//  ;; increase the index
//  (incf *memory-size*)
//  (incf *newly-added*)
//  ;; add the object to GM, by appending to the end of list
//  (setf *generic-memory* (cons new-fact *generic-memory*)))
//
//;;; **** Add a rule to Generic Memory
//(defun add-rule-to-mem (head &optional body w e+ e- ancestors ancestor-to)
//  ;; Set default values:
//  (****DEBUG 1 "adding rule to memory: ~a <- ~a" head body)
//  (if (null body) (setf body '(*bodyless*)))
//  (if (null w )   (setf w    100))
//  (if (null e+)   (setf e+   0))
//  (if (null e-)   (setf e-   0))
//  ;; create an object
//  (setf new-rule (make-instance 'rule-item
//                          :head         head
//                          :body         body
//                          :id           *memory-size*
//                          :w            w
//                          :e+           e+
//                          :e-           e-
//                          :ancestors    ancestors
//                          :ancestor-to  ancestor-to))
//  ;; increase the index
//  (incf *memory-size*)
//  (incf *newly-added*)
//  ;; add the object to GM, by appending to the end of list
//  (setf *generic-memory* (cons new-rule *generic-memory*)))
//
//(defun delete-memory-item (item)
//  (setf ptr *generic-memory*)
//  ;; Special case:
//  (if (eql item ptr)
//    (return-from delete-memory-item
//      (setf *generic-memory* (cdr *generic-memory*))))
//  ;; Otherwise, find the item
//  (loop
//    (if (eql item (cdr ptr)) (return))
//    (setf ptr (cdr ptr)))
//  ;; Delete it
//  (setf (cdr ptr) (cdr item)))
//
//;;; Fetch all clauses in KB with the given head-predicate
//;;; Return: a list of rules
//(defun fetch-clauses (head-predicate)
//  (let ((facts-list (list nil))
//        (rules-list (list nil)))
//    (dolist (item *generic-memory*)
//      ;; is it a rule?
//      (if (eql (type-of item) 'rule-item)
//        (let ((head (head item))
//              (body (body item)))
//          ;; Does head of rule match head-predicate?
//          (if (equal (car head) head-predicate)
//            (progn
//              ;; calculate the confidence c from w
//              ;; the function is defined in "PZ-calculus.lisp"
//              (setf confidence (convert-w-2-c (w item)))
//              ;; add it to list-to-be-returned
//              (nconc rules-list (list (make-instance 'clause
//                                        :id         (id item)
//                                        :confidence confidence
//                                        :head       head
//                                        :body       body))))))
//        ;; If it is a fact:
//        ;; Does fact match head-predicate?
//        (if (equal (car (fact item)) head-predicate)
//          (let ((tv (tv item)))
//            ;; add it to list-to-be-returned
//            (nconc facts-list (list (make-instance 'clause
//                                      :id         (id item)
//                                      :confidence (cdr tv)
//                                      :head       (fact item)
//                                      :tv         tv)))))))
//    ;; return the 2 lists, discarding the leading 'nil' items
//    (values (cdr facts-list) (cdr rules-list))))
//
//;;; Comparison predicate for "sort" in function "fetch-clauses"
//;;; should return true iff x1 is strictly less than x2
//;;; if x1 is greater than or equal to x2, return false
//;;; sort seems to order from small to big -- we need to reverse this -- biggest confidence 1st
//;;; each element is a list:  (confidence head body)
//(defun compare-items (x1 x2)
//  (> (car x1) (car x2)))
//
//;;; This function is used in natural-language.lisp
//(defvar *entity-counter* 1)
//;;; **** Creates a new entity
//(defun new-entity ()
//  (incf *entity-counter*))
//
//;;; ------------------------ miscellaneous functions -------------------------
//
//;;; **** Print out memory contents
//(defun dump-memory ()
//  (dolist (item *generic-memory*)
//    (if (eql (type-of item) 'fact-item)
//      ;; print a fact item
//      (progn
//        (format t "**** [~a] fact: ~a ~%" (id item) (fact item))
//        (setf tv (tv item))
//        (format t "  TV:           ~a ~%" (car tv))
//        (format t "  confidence:   ~a ~%" (cdr tv))
//        (format t "  justifies:    ~a ~%" (justifies    item))
//        (format t "  justified-by: ~a ~%" (justified-by item)))
//      ;; print a rule item
//      (progn
//        (format t "**** [~a] rule: ~%"    (id          item))
//        (format t "  head:         ~a ~%" (head        item))
//        (format t "  body:         ~a ~%" (body        item))
//        (format t "  w:            ~a ~%" (w           item))
//        (format t "  e+:           ~a ~%" (e+          item))
//        (format t "  e-:           ~a ~%" (e-          item))
//        (format t "  ancestors:    ~a ~%" (ancestors   item))
//        (format t "  ancestors-to: ~a ~%" (ancestor-to item))))))
	
	
	
//;;; **** Initialize memories
//(defun init-memories ()
//  ;; Generic Memory
//  (setf *generic-memory* nil)
//  ;; index
//  (setf *memory-size* 0)
//  ;; counter used in batch processing
//  (setf *newly-added* 0)
//
//  (format t ";; Adding knowledge to KB.... ~%")
//
//  ;;; the format for facts is:
//  ;;;   (add-fact-to-mem (head) (TV) (justifies) (justified-by))
//  ;;;   where
//  ;;;      (TV) = (truth value . confidence)
//
//  ;;; the format for rules is:
//  ;;;   (add-rule-to-mem (head) (body) w+ w e+ e- ancestors ancestors-to)
//
//  ;;; ************* Example 1
//  ;;; This example occurs in this scenario:
//  ;;;   "I ask Kellie out for a date, but she says she is busy. Then, I find her drinking
//  ;;;   at the bar. Therefore, Kellie is lying."
//  ;;; It contains the simple rules:
//  ;;;   1. at_bar(x) -> having_fun(x)
//  ;;;   2. busy(x) -> ! having_fun(x)
//  ;;; and the following fact:
//  ;;;   busy(kellie)
//  ;;; The query would be:
//  ;;;   (at-bar kellie) ?
//  ;;; And the answer would be false (or its equivalent numerical truth value)
//
//  (add-fact-to-mem '(busy kellie) '(0.7 . 1.0))
//
//  (add-rule-to-mem '(having-fun ?1) '(Z-NOT (busy ?1)))
//  (add-rule-to-mem '(having-fun ?1) '(Z-MOD2 (at-bar ?1) 0.5 5.0))
//
//  ;;; ************* Example 2
//  ;;; Just a 6-layer-deep search problem with a distracting branch
//  ;;; Query:  (goal robot) ?
//  (add-fact-to-mem '(do-a robot) '(0.6 . 1.0))
//
//  (add-rule-to-mem '(do-b ?1) '(Z-MOD2 (do-a ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-c ?1) '(Z-MOD2 (do-b ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-d ?1) '(Z-MOD2 (do-c ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-e ?1) '(Z-MOD2 (do-d ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-f ?1) '(Z-MOD2 (do-e ?1) 0.5 5.0))
//  (add-rule-to-mem '(goal ?1) '(Z-MOD2 (do-f ?1) 0.5 5.0))
//  ; let's add a little distraction:
//  (add-rule-to-mem '(do-x ?1) '(Z-MOD2 (do-w ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-y ?1) '(Z-MOD2 (do-x ?1) 0.5 5.0))
//  (add-rule-to-mem '(do-z ?1) '(Z-MOD2 (do-y ?1) 0.5 5.0))
//  (add-rule-to-mem '(goal ?1) '(Z-MOD2 (do-z ?1) 0.5 5.0))
//
//  ;;; ************* Example 3
//  ;;; c is a chair:
//  ;;;     chair(X) <- leg(1,X) & leg(2,X) & leg(3,X) & leg(4,X) & seat(X) & back(X)
//  ;;; Query:  (chair c) ?
//  (add-fact-to-mem '(leg 1 c) '(0.7 . 1.0))
//  (add-fact-to-mem '(leg 2 c) '(0.8 . 1.0))
//  (add-fact-to-mem '(leg 3 c) '(0.9 . 1.0))
//  (add-fact-to-mem '(leg 4 c) '(0.8 . 1.0))
//  (add-fact-to-mem '(seat  c) '(0.7 . 1.0))
//  (add-fact-to-mem '(back  c) '(0.9 . 1.0))
//
//  (add-rule-to-mem '(chair ?1) '(Z-AND (seat  ?1)
//                                       (back  ?1)
//                                       (leg 1 ?1)
//                                       (leg 2 ?1)
//                                       (leg 3 ?1)
//                                       (leg 4 ?1)))
//
//  ;;; A longer version using multiple intermediary predicates
//  ;;; Query:  (chair2 c) ?
//  (add-rule-to-mem '(chair2 ?1) '(Z-AND (seat  ?1) (tmp4  ?1)))
//  (add-rule-to-mem '(tmp4   ?1) '(Z-AND (back  ?1) (tmp3  ?1)))
//  (add-rule-to-mem '(tmp3   ?1) '(Z-AND (leg 1 ?1) (tmp2  ?1)))
//  (add-rule-to-mem '(tmp2   ?1) '(Z-AND (leg 2 ?1) (tmp1  ?1)))
//  (add-rule-to-mem '(tmp1   ?1) '(Z-AND (leg 3 ?1) (leg 4 ?1)))
//
//  ;;; ************* Example 4
//  ;;; From Luger's AI textbook, 2009
//  ;;; Query:  (happy john) ?
//
//  ;;; Anyone passing his history exams and winning the lottery is happy:
//  (add-rule-to-mem '(happy ?1) '(Z-AND (pass ?1 history) (win ?1 lottery)))
//
//  ;;; Anyone who studies or is lucky can pass all his exams:
//  (add-rule-to-mem '(pass ?1 ?2) '(Z-OR (study ?1) (lucky ?1)))
//
//  ;;; John did not study but is lucky:
//  (add-fact-to-mem '(study john) '(0.0 . 1.0))
//  (add-fact-to-mem '(lucky john))
//
//  ;;; Anyone who is lucky wins the lottery:
//  (add-rule-to-mem '(win ?1 lottery) '(ID (lucky ?1)))
//
//  ;;; ************* Example 5
//  ;;; Test handling of function symbols, ie unification.
//  ;;; Query:  (grandparent john ?1)
//
//  ;;; This is an example of a body-less rule:
//  ;;; parent(X, son-of(X)) <-
//  (add-rule-to-mem '(parent ?1 (son-of ?1)))
//
//  ;;; ~parent(W,Y) \/ ~parent(Y,Z) \/ grandparent(W,Z)
//  (add-rule-to-mem '(grandparent ?1 ?3) '(Z-AND (parent ?1 ?2) (parent ?2 ?3)))
//
//  ;;; ************* Example 6
//  ;;; Test of variable binding across a conjunction.
//  ;;;     p(X,Y) <- q(X,Z) /\ r(Z,Y)
//
//  ;;;     grandpa(X,Y) <- pa(X,Z) /\ pa(Z,Y)
//  ;;;     grandpa(X,Y) <- pa(X,Z) /\ ma(Z,Y)
//  ;;;     pa(john,pete)
//  ;;;     pa(pete,paul)
//  ;;;     ma(mary,paul)
//  ;;;     pa(john,mary)
//  ;;; Query: grandpa(john,paul)?
//  ;;; Query: grandpa(john,sam)?
//
//  (add-rule-to-mem '(grandpa ?1 ?2) '(Z-AND (pa ?1 ?3) (pa ?3 ?2)))
//  (add-rule-to-mem '(grandpa ?1 ?2) '(Z-AND (pa ?1 ?3) (ma ?3 ?2)))
//  (add-fact-to-mem '(pa john pete) '(1.0 . 1.0))
//  (add-fact-to-mem '(pa pete paul) '(1.0 . 1.0))
//  (add-fact-to-mem '(ma mary sam)  '(1.0 . 1.0))
//  (add-fact-to-mem '(pa john mary) '(1.0 . 1.0))
//
//  ;;; ************* Example 7
//  ;;; This background knowledge is used for testing induction in "induction1.lisp"
//  ;;; Query: (has-dau pam) ?   **** should return false
//
//  ;(add-rule-to-mem '(has-dau ?1) '(Z-AND (parent ?1 ?2) (female ?2)))
//
//  (add-fact-to-mem '(parent pam bob))
//  (add-fact-to-mem '(parent tom bob))
//  (add-fact-to-mem '(parent tom liz))
//  (add-fact-to-mem '(parent bob ann))
//  (add-fact-to-mem '(parent bob pat))
//  (add-fact-to-mem '(parent pat jim))
//  (add-fact-to-mem '(parent pat eve))
//  ;(add-fact-to-mem '(parent juu luu))
//
//  (add-fact-to-mem '(female pam))
//  (add-fact-to-mem '(male tom))
//  (add-fact-to-mem '(male bob))
//  (add-fact-to-mem '(female liz))
//  (add-fact-to-mem '(female ann))
//  (add-fact-to-mem '(female pat))
//  (add-fact-to-mem '(male jim))
//  (add-fact-to-mem '(female eve))
//  ;(add-fact-to-mem '(male juu))
//  ;(add-fact-to-mem '(male luu))
//
//  (format t ";; Working Memory initialized... ~%"))
	
}