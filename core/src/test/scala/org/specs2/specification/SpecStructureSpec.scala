package org.specs2
package specification

import org.specs2.main.Arguments
import org.specs2.specification.core._

class SpecStructureSpec extends Specification { def is = s2"""

 A spec structure depends on another if it has links to it $a1

"""

  def a1 = {
    lazy val s1 = SpecStructure(SpecHeader(classOf[S1]), Arguments(), Fragments(fragmentFactory.link(SpecificationLink(s2.header))))
    lazy val s2 = SpecStructure(SpecHeader(classOf[S2]), Arguments(), Fragments())
    SpecStructure.dependsOn(s1, s2) and SpecStructure.dependsOn(s2, s1).not
  }

  trait S1
  trait S2
}
