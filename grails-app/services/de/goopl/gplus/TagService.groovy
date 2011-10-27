package de.goopl.gplus

class TagService {
    static final CITYTAGS_CACHE_KEY = "cityTagsList"

       static transactional = false

      // def redis

       def extractTagsFromMessage(User user) {          // TODO: other name
//           try {
//               // split message, prove size <= 30, add to tags
//               def tags = [] as Set
//               (user.cityTags as List).first().split(/,/).each {
//                   it = it.toString().trim()
//                   if (it.toString().size() <= 30) tags << it
//               }
//
//               if (!tags) return
//
//               log.debug "Adding cityTags '${tags.join(', ')}' to user ${user.id}"
//               user.cityTags = tags as Set
//              //user.save(flush: true, failOnError: true)
//
//               // Update tag cache in Redis.
////               cacheTags()
//               user.cityTags
//           }
//           catch (e) {
//               e.printStackTrace()
//           }
       }
    def cacheTags() {
//          try {
//              def result = User.collection.mapReduce("""\
//                      function map() {
//                          if (!this.cityTags) {
//                              return;
//                          }
//
//                          for (index in this.cityTags) {
//                              emit(this.cityTags[index], 1);
//                          }
//                      }
//                      """.stripIndent(),
//                      """\
//                      function reduce(key, values) {
//                          var count = 0;
//
//                          for (index in values) {
//                              count += values[index];
//                          }
//
//                          return count;
//                      }
//                      """.stripIndent(),
//                      "mrresult",
//                      [:])
//
//              redis.multi()
//              redis.del CITYTAGS_CACHE_KEY
//              for (r in result.results()) {
//                  redis.zadd CITYTAGS_CACHE_KEY, r.value.toDouble(), r._id
//              }
//              redis.exec()
//          }
//          finally {
//              redis.close()
//          }
      }

      Map getTags() {
//          try {
//              def tags = getTagsInternal()
//              if (!tags) {
//                  cacheTags()
//                  tags = getTagsInternal()
//              }
//              if (tags) {
//                  // Return a map of tag names -> tag counts. At this point,
//                  // 'tags' is a list of tag names, so we use redis.zscore()
//                  // to get the associated tag count.
//                  return tags.reverse().inject([:]) { map, k -> map[k] = redis.zscore(CITYTAGS_CACHE_KEY, k).toInteger(); return map }
//              }
//              else {
//                  return [:]
//              }
//          }
//          finally {
//              redis.close()
//          }
      }

      private getTagsInternal() {
//          def x = redis.zrange(CITYTAGS_CACHE_KEY, 0, -1) as List
//          x
      }
  }