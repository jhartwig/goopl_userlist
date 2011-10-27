package de.goopl.gplus

class TagController {

    def tagService

    def index = {
        def xxx
        return [tags: tagService.getTags() ]
    }
}
